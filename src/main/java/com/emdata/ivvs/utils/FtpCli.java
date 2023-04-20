package com.emdata.ivvs.utils;

import com.emdata.ivvs.common.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 2019/5/29.
 */
public class FtpCli {

    private static final Logger LOGGER = LoggerFactory.getLogger(FtpCli.class);


    private static String DEFAULT_CHARSET = "UTF-8";
    //private static String DEFAULT_CHARSET = "GB2312";
    private static final int DEFAULT_TIMEOUT = 0;
    private static String DAILY_FILE_PATH = "/data/public/violation";
    private String host;
    private int port;
    private String username;
    private String password;
    private FTPClient ftpClient;
    private volatile String ftpBasePath;



    private FtpCli(String host, String username, String password,String charSet) {
        this(host, 21, username, password, StringUtil.isBlank(charSet)?DEFAULT_CHARSET:charSet);
        setTimeout(DEFAULT_TIMEOUT, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT);
    }


    private FtpCli(String host, int port, String username, String password, String charset) {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding(StringUtil.isBlank(charset)?DEFAULT_CHARSET:charset);
        this.host = StringUtils.isEmpty(host) ? "localhost" : host;
        this.port = (port <= 0) ? 21 : port;
        this.username = StringUtils.isEmpty(username) ? "anonymous" : username;
        this.password = password;
        setTimeout(DEFAULT_TIMEOUT, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT);
    }


    /**
     * <p>Description:[创建默认的ftp客户端]</p>
     * @param host     主机名或者ip地址
     * @param username ftp用户名
     * @param password ftp密码
     * @return com.moy.demo.common.utils.FtpCli
     */
    public static FtpCli createFtpCli(String host, String username, String password,String charSet) {
        return new FtpCli(host, username, password,charSet);
    }


    /**
     * <p>Description:[创建自定义属性的ftp客户端]</p>
     * @param host     主机名或者ip地址
     * @param port     ftp端口
     * @param username ftp用户名
     * @param password ftp密码
     * @param charset  字符集
     * @return com.moy.demo.common.utils.FtpCli
     */
    public static FtpCli createFtpCli(String host, int port, String username, String password, String charset) {
        return new FtpCli(host, port, username, password, charset);
    }


    /**
     * 设置超时时间
     * @param defaultTimeout
     * @param connectTimeout
     * @param dataTimeout
     */
    public void setTimeout(int defaultTimeout, int connectTimeout, int dataTimeout) {
        ftpClient.setDefaultTimeout(defaultTimeout);
        ftpClient.setConnectTimeout(connectTimeout);
        ftpClient.setDataTimeout(dataTimeout);
    }


    /**
     * @param dir ftp服务器上目录
     * @return boolean 改变成功返回true
     */
    public boolean changeWorkingDirectory(String dir) {
        if (!ftpClient.isConnected()) {
            return false;
        }
        try {
            return ftpClient.changeWorkingDirectory(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * <p>Description:[连接到ftp]</p>
     */
    public void connect() throws IOException {
        try {
            ftpClient.connect(host, port);
        } catch (UnknownHostException e) {
            throw new IOException("Can't find FTP server :" + host);
        }
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            disconnect();
            throw new IOException("Can't connect to server :" + host);
        }

        if (!ftpClient.login(username, password)) {
            disconnect();
            throw new IOException("Can't login to server :" + host);
        }

        if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))) {
            //开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
            ftpClient.setControlEncoding("UTF-8");
        }

        // set data transfer mode.
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        // Use passive mode to pass firewalls.
        ftpClient.enterLocalPassiveMode();
        //ftpClient.enterLocalActiveMode();
        initFtpBasePath();
    }


    /**
     * <p>Description:[连接ftp时保存刚登陆ftp时的路径]</p>
     *
     */
    private void initFtpBasePath() throws IOException {
        if (StringUtils.isEmpty(ftpBasePath)) {
            synchronized (this) {
                if (StringUtils.isEmpty(ftpBasePath)) {
                    ftpBasePath = ftpClient.printWorkingDirectory();
                    LOGGER.info("initFtpBasePath is:{}",ftpBasePath);
                }
            }
        }
    }


    /**
     * <p>Description:[关闭ftp连接]</p>
     *
     */
    public void disconnect() {
        if (null != ftpClient && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException ex) {
                // do nothing
                LOGGER.error("ftpClient disconnect IOException :{}",ex);
            }
        }
    }



    /**
     * <p>Description:[上传文件到对应日期文件下，
     * 如当前时间是2018-06-06，则上传到[ftpBasePath]/[DAILY_FILE_PATH]/2018/06/06/下]</p>
     *
     * @param fileName    文件名
     * @param inputStream 文件输入流
     * @return java.lang.String
     */
    public String uploadFileToDailyDir(String fileName, InputStream inputStream) throws IOException {
        changeWorkingDirectory(ftpBasePath);
        SimpleDateFormat dateFormat = new SimpleDateFormat("/yyyy/MM/dd");
        String formatDatePath = dateFormat.format(new Date());
        String uploadDir = DAILY_FILE_PATH + formatDatePath;
        makeDirs(uploadDir);
        storeFile(fileName, inputStream);
        return formatDatePath + "/" + fileName;
    }


    /**
     * <p>Description:[下载ftp服务器下文件夹到本地]</p>
     *
     * @param remotePath ftp上文件夹路径名称
     * @param localPath  本地上传的文件夹路径名称
     * @return void
     */
    public void downloadDir(String remotePath, String localPath,String fileName) throws IOException {
        localPath = localPath.replace("\\\\", "/");
        File file = new File(localPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        ftpClient.enterLocalPassiveMode();
        FTPFile[] ftpFiles = ftpClient.listFiles(remotePath);
        for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
            FTPFile ftpFile = ftpFiles[i];
            if (ftpFile.isDirectory() && !ftpFile.getName().equals(".") && !ftpFile.getName().equals("..")) {
                downloadDir(remotePath + "/" + ftpFile.getName(), localPath + "/" + ftpFile.getName(),fileName);
            } else {
                download(remotePath + "/" + ftpFile.getName(), new File(localPath + "/" + ftpFile.getName()));
            }
        }
    }

    /**
     * <p>Description:[下载ftp服务器指定文件下载到到本地]</p>
     *
     * @param remotePath ftp上文件夹路径名称
     * @param localPath  本地上传的文件夹路径名称
     * @return void
     */
    public Boolean downloadFile(String remotePath, String localPath,String fileName) throws IOException {
        boolean flag = false;
        OutputStream os=null;
        try {
            LOGGER.info("start download file:{}"+remotePath+"/"+fileName);
            if(ftpClient==null){
                return flag;
            }
            localPath = localPath.replace("\\\\", "/");
            File hostFile = new File(localPath);
            if (!hostFile.exists()) {
                hostFile.mkdirs();
            }
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //切换FTP目录
            ftpClient.changeWorkingDirectory(remotePath);
            ftpClient.enterLocalPassiveMode();
            FTPFile[] ftpFiles = ftpClient.listFiles();
            if(ftpFiles!=null&&ftpFiles.length>0){
                for(FTPFile ftpFile : ftpFiles){
                    if(fileName.equalsIgnoreCase(ftpFile.getName())){
                        File localFile = new File(localPath + "/" + ftpFile.getName());
                        os = new FileOutputStream(localFile);
                        ftpClient.retrieveFile(ftpFile.getName(), os);
                        os.close();
                        LOGGER.info("download file success:{}",fileName);
                        return true;
                    }
                }
            }
            flag = false;
            LOGGER.info("download file fail,is not find:{}"+remotePath+"/"+fileName);
        } catch (Exception e) {
            LOGGER.error("download fail Exception is:{}",e);
            connect();
        } finally{
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    LOGGER.error("Finally IOException Exception is:{}",e);
                }
            }
        }
        return flag;
    }


    /**
     * <p>Description:[根据文件ftp路径名称删除文件]</p>
     *
     * @param ftpFileName 文件ftp路径名称
     */
    public void deleteFile(String ftpFileName) throws IOException {
        Boolean deleteSuccess = false;
        if (ftpClient.deleteFile(ftpFileName)) {
            deleteSuccess = true;
        }else{
            throw new IOException("Can't remove file '" + ftpFileName + "' from FTP server.");
        }
        LOGGER.info("deleteFile deleteSuccess is {} filename:[{}]",deleteSuccess,ftpFileName);
    }


    /**
     * <p>Description:[下载ftp文件到本地上]</p>
     * @param ftpFileName ftp文件路径名称
     * @param localFile   本地文件路径名称
     */
    public void download(String ftpFileName, File localFile) throws IOException {
        OutputStream out = null;
        try {
            ftpClient.enterLocalPassiveMode();
            FTPFile[] fileInfoArray = ftpClient.listFiles(ftpFileName);
            if (fileInfoArray == null || fileInfoArray.length == 0) {
                throw new FileNotFoundException("File " + ftpFileName + " was not found on FTP server.");
            }

            FTPFile fileInfo = fileInfoArray[0];
            if (fileInfo.getSize() > Integer.MAX_VALUE) {
                throw new IOException("File " + ftpFileName + " is too large.");
            }

            out = new BufferedOutputStream(new FileOutputStream(localFile));
            if (!ftpClient.retrieveFile(ftpFileName, out)) {
                throw new IOException("Error loading file " + ftpFileName + " from FTP server. Check FTP permissions and path.");
            }
            out.flush();
        } finally {
            closeStream(out);
        }
    }




    /**
     * <p>Description:[创建多个目录]</p>
     * @param pathname 路径名
     */
    public void makeDirs(String pathname) throws IOException {
        pathname = pathname.replace("\\\\", "/");
        String[] pathnameArray = pathname.split("/");
        for (String each : pathnameArray) {
            if (StringUtils.isNotEmpty(each)) {
                ftpClient.makeDirectory(each);
                ftpClient.changeWorkingDirectory(each);
            }
        }
    }


    /**
     * <p>Description:[将输入流存储到指定的ftp路径下]</p>
     *
     * @param ftpFileName 文件在ftp上的路径 如绝对路径 /home/ftpuser/123.txt 或者相对路径 123.txt
     * @param in          输入流
     */
    public void storeFile(String ftpFileName, InputStream in) throws IOException {
        try {
            if (!ftpClient.storeFile(ftpFileName, in)) {
                throw new IOException("Can't upload file '" + ftpFileName + "' to FTP server. Check FTP permissions and path.");
            }
        } finally {
            closeStream(in);
        }
    }


    /**
     * <p>Description:[关闭流]</p>
     *
     * @param stream 流
     */
    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException ex) {
                // do nothing
            }
        }
    }

    /**
     * <p>Description:[列出ftp上文件目录下的文件]</p>
     * @param filePath
     * @return
     * @throws IOException
     */
    
    public List<String> listFileNames(String filePath) throws IOException {
    	List<String> fileList = new ArrayList<>();
    	ftpClient.changeWorkingDirectory(filePath);
    	System.out.println(ftpClient.printWorkingDirectory());
    	String[] aa   =ftpClient.listNames();
    	for (String str : aa) {
    		 fileList.add(filePath + str);
		}
		/*
		 * FTPFile[] ftpFiles = ftpClient.listFiles(); if (ftpFiles != null) { for (int
		 * i = 0,len=ftpFiles.length;i <len; i++) { FTPFile ftpFile = ftpFiles[i]; if
		 * (ftpFile.isFile()) { //fileList.add(ftpFile.getName()); fileList.add(filePath
		 * + ftpFile.getName()); }else{
		 * //需要加此判断。否则，ftp默认将‘项目文件所在目录之下的目录（./）’与‘项目文件所在目录向上一级目录下的目录（../）’都纳入递归，
		 * 这样下去就陷入一个死循环了。需将其过滤掉
		 * //LOGGER.info("path is: {} filename: {}",filePath,ftpFile.getName()); if
		 * (!".".equals(ftpFile.getName()) && !"..".equals(ftpFile.getName())) {
		 * //listFileNames(filePath + ftpFile.getName() + "/"); } } } }
		 */
        return fileList;
    }


    /**
     * 递归遍历目录下面指定的文件名
     *
     * @param pathName 需要遍历的目录，必须以"/"开始和结束
     * @param ext      文件的扩展名
     * @throws IOException
     */
    public void List(String pathName, String ext) throws IOException {
        ArrayList<String> arFiles = new ArrayList<String>();
        if (pathName.startsWith("/") && pathName.endsWith("/")) {
            //更换目录到当前目录
            this.ftpClient.changeWorkingDirectory(pathName);
            FTPFile[] files = this.ftpClient.listFiles();
            for (FTPFile file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(ext)) {
                        arFiles.add(pathName + file.getName());
                    }
                } else if (file.isDirectory()) {
                    if (!".".equals(file.getName()) && !"..".equals(file.getName())) {
                        List(pathName + file.getName() + "/", ext);
                    }
                }
            }
        }
    }



    /**
     * 遍历视频格式后缀
     * @return
     */
    private List<String> videoList(){
        List<String> prefixList = new ArrayList<>();
        prefixList.add(".mp4");
        prefixList.add(".MP4");
        prefixList.add(".avi");
        prefixList.add(".AVI");
        return prefixList;
    }


    /**
     * 检测视频是否存在
     * @param ftpPath
     * @param fileName
     * @return
     */
    public String checkRemoteFileExistence(String ftpPath,String fileName){
        String isExsitsPath = "";
        try {
            String setPathFix = "";
            List<String> prefixListStr =  videoList();
            for (String fixStr:prefixListStr) {
                setPathFix = ftpPath + fileName + fixStr;
                FTPFile[] files = ftpClient.listFiles(setPathFix);
                if (files != null && files.length > 0) {
                    isExsitsPath = fileName + fixStr;
                    break;
                }
            }
        }catch (Exception ex){}
        return isExsitsPath;
    }


    /**
     * 获取最后修改时间
     * @param path
     * @return
     * @throws IOException
     */
    public String getlastmodifyTime(String path) throws IOException {
           return ftpClient.getModificationTime(path);
    }
}
