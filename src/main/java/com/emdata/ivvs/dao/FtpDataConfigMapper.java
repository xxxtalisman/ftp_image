package com.emdata.ivvs.dao;

import com.emdata.ivvs.vo.RuleVo;

import java.util.List;

/**
 * Created by tanglingxin on 2019/12/24.
 */
public interface FtpDataConfigMapper {

    List<RuleVo> queryLastestConfig(RuleVo ruleVo);
}
