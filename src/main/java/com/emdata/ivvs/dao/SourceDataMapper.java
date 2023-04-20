package com.emdata.ivvs.dao;

import com.emdata.ivvs.vo.InsertSourceVo;

/**
 * Created by tanglingxin on 2019/12/24.
 */
public interface SourceDataMapper {


    /**
     * 新增违法数据
     * @param vo
     * @return
     */
    Integer insertSelective(InsertSourceVo vo);



    /**
     * 修改视频地址关联对应数据
     * @param vo
     * @return
     */
    Integer updateSelective(InsertSourceVo vo);


    /**
     * 查询该视频文件名称是否存在有关联的数据
     * @param vo
     * @return
     */
    InsertSourceVo selectSelective(InsertSourceVo vo);
}
