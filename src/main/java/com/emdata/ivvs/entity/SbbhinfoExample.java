package com.emdata.ivvs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 2019/7/2.
 */
public class SbbhinfoExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SbbhinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSbidIsNull() {
            addCriterion("sbid is null");
            return (Criteria) this;
        }

        public Criteria andSbidIsNotNull() {
            addCriterion("sbid is not null");
            return (Criteria) this;
        }

        public Criteria andSbidEqualTo(Integer value) {
            addCriterion("sbid =", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotEqualTo(Integer value) {
            addCriterion("sbid <>", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidGreaterThan(Integer value) {
            addCriterion("sbid >", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sbid >=", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidLessThan(Integer value) {
            addCriterion("sbid <", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidLessThanOrEqualTo(Integer value) {
            addCriterion("sbid <=", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidIn(List<Integer> values) {
            addCriterion("sbid in", values, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotIn(List<Integer> values) {
            addCriterion("sbid not in", values, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidBetween(Integer value1, Integer value2) {
            addCriterion("sbid between", value1, value2, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotBetween(Integer value1, Integer value2) {
            addCriterion("sbid not between", value1, value2, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbbhIsNull() {
            addCriterion("sbbh is null");
            return (Criteria) this;
        }

        public Criteria andSbbhIsNotNull() {
            addCriterion("sbbh is not null");
            return (Criteria) this;
        }

        public Criteria andSbbhEqualTo(String value) {
            addCriterion("sbbh =", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhNotEqualTo(String value) {
            addCriterion("sbbh <>", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhGreaterThan(String value) {
            addCriterion("sbbh >", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhGreaterThanOrEqualTo(String value) {
            addCriterion("sbbh >=", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhLessThan(String value) {
            addCriterion("sbbh <", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhLessThanOrEqualTo(String value) {
            addCriterion("sbbh <=", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhLike(String value) {
            addCriterion("sbbh like", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhNotLike(String value) {
            addCriterion("sbbh not like", value, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhIn(List<String> values) {
            addCriterion("sbbh in", values, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhNotIn(List<String> values) {
            addCriterion("sbbh not in", values, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhBetween(String value1, String value2) {
            addCriterion("sbbh between", value1, value2, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbbhNotBetween(String value1, String value2) {
            addCriterion("sbbh not between", value1, value2, "sbbh");
            return (Criteria) this;
        }

        public Criteria andSbmcIsNull() {
            addCriterion("sbmc is null");
            return (Criteria) this;
        }

        public Criteria andSbmcIsNotNull() {
            addCriterion("sbmc is not null");
            return (Criteria) this;
        }

        public Criteria andSbmcEqualTo(String value) {
            addCriterion("sbmc =", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcNotEqualTo(String value) {
            addCriterion("sbmc <>", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcGreaterThan(String value) {
            addCriterion("sbmc >", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcGreaterThanOrEqualTo(String value) {
            addCriterion("sbmc >=", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcLessThan(String value) {
            addCriterion("sbmc <", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcLessThanOrEqualTo(String value) {
            addCriterion("sbmc <=", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcLike(String value) {
            addCriterion("sbmc like", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcNotLike(String value) {
            addCriterion("sbmc not like", value, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcIn(List<String> values) {
            addCriterion("sbmc in", values, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcNotIn(List<String> values) {
            addCriterion("sbmc not in", values, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcBetween(String value1, String value2) {
            addCriterion("sbmc between", value1, value2, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSbmcNotBetween(String value1, String value2) {
            addCriterion("sbmc not between", value1, value2, "sbmc");
            return (Criteria) this;
        }

        public Criteria andSblxIsNull() {
            addCriterion("sblx is null");
            return (Criteria) this;
        }

        public Criteria andSblxIsNotNull() {
            addCriterion("sblx is not null");
            return (Criteria) this;
        }

        public Criteria andSblxEqualTo(String value) {
            addCriterion("sblx =", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxNotEqualTo(String value) {
            addCriterion("sblx <>", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxGreaterThan(String value) {
            addCriterion("sblx >", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxGreaterThanOrEqualTo(String value) {
            addCriterion("sblx >=", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxLessThan(String value) {
            addCriterion("sblx <", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxLessThanOrEqualTo(String value) {
            addCriterion("sblx <=", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxLike(String value) {
            addCriterion("sblx like", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxNotLike(String value) {
            addCriterion("sblx not like", value, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxIn(List<String> values) {
            addCriterion("sblx in", values, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxNotIn(List<String> values) {
            addCriterion("sblx not in", values, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxBetween(String value1, String value2) {
            addCriterion("sblx between", value1, value2, "sblx");
            return (Criteria) this;
        }

        public Criteria andSblxNotBetween(String value1, String value2) {
            addCriterion("sblx not between", value1, value2, "sblx");
            return (Criteria) this;
        }

        public Criteria andSbztIsNull() {
            addCriterion("sbzt is null");
            return (Criteria) this;
        }

        public Criteria andSbztIsNotNull() {
            addCriterion("sbzt is not null");
            return (Criteria) this;
        }

        public Criteria andSbztEqualTo(String value) {
            addCriterion("sbzt =", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotEqualTo(String value) {
            addCriterion("sbzt <>", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThan(String value) {
            addCriterion("sbzt >", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThanOrEqualTo(String value) {
            addCriterion("sbzt >=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThan(String value) {
            addCriterion("sbzt <", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThanOrEqualTo(String value) {
            addCriterion("sbzt <=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLike(String value) {
            addCriterion("sbzt like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotLike(String value) {
            addCriterion("sbzt not like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztIn(List<String> values) {
            addCriterion("sbzt in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotIn(List<String> values) {
            addCriterion("sbzt not in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztBetween(String value1, String value2) {
            addCriterion("sbzt between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotBetween(String value1, String value2) {
            addCriterion("sbzt not between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbcxIsNull() {
            addCriterion("sbcx is null");
            return (Criteria) this;
        }

        public Criteria andSbcxIsNotNull() {
            addCriterion("sbcx is not null");
            return (Criteria) this;
        }

        public Criteria andSbcxEqualTo(String value) {
            addCriterion("sbcx =", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxNotEqualTo(String value) {
            addCriterion("sbcx <>", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxGreaterThan(String value) {
            addCriterion("sbcx >", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxGreaterThanOrEqualTo(String value) {
            addCriterion("sbcx >=", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxLessThan(String value) {
            addCriterion("sbcx <", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxLessThanOrEqualTo(String value) {
            addCriterion("sbcx <=", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxLike(String value) {
            addCriterion("sbcx like", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxNotLike(String value) {
            addCriterion("sbcx not like", value, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxIn(List<String> values) {
            addCriterion("sbcx in", values, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxNotIn(List<String> values) {
            addCriterion("sbcx not in", values, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxBetween(String value1, String value2) {
            addCriterion("sbcx between", value1, value2, "sbcx");
            return (Criteria) this;
        }

        public Criteria andSbcxNotBetween(String value1, String value2) {
            addCriterion("sbcx not between", value1, value2, "sbcx");
            return (Criteria) this;
        }

        public Criteria andWbdwIsNull() {
            addCriterion("wbdw is null");
            return (Criteria) this;
        }

        public Criteria andWbdwIsNotNull() {
            addCriterion("wbdw is not null");
            return (Criteria) this;
        }

        public Criteria andWbdwEqualTo(String value) {
            addCriterion("wbdw =", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwNotEqualTo(String value) {
            addCriterion("wbdw <>", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwGreaterThan(String value) {
            addCriterion("wbdw >", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwGreaterThanOrEqualTo(String value) {
            addCriterion("wbdw >=", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwLessThan(String value) {
            addCriterion("wbdw <", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwLessThanOrEqualTo(String value) {
            addCriterion("wbdw <=", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwLike(String value) {
            addCriterion("wbdw like", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwNotLike(String value) {
            addCriterion("wbdw not like", value, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwIn(List<String> values) {
            addCriterion("wbdw in", values, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwNotIn(List<String> values) {
            addCriterion("wbdw not in", values, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwBetween(String value1, String value2) {
            addCriterion("wbdw between", value1, value2, "wbdw");
            return (Criteria) this;
        }

        public Criteria andWbdwNotBetween(String value1, String value2) {
            addCriterion("wbdw not between", value1, value2, "wbdw");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andZcodeIsNull() {
            addCriterion("zcode is null");
            return (Criteria) this;
        }

        public Criteria andZcodeIsNotNull() {
            addCriterion("zcode is not null");
            return (Criteria) this;
        }

        public Criteria andZcodeEqualTo(String value) {
            addCriterion("zcode =", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeNotEqualTo(String value) {
            addCriterion("zcode <>", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeGreaterThan(String value) {
            addCriterion("zcode >", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeGreaterThanOrEqualTo(String value) {
            addCriterion("zcode >=", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeLessThan(String value) {
            addCriterion("zcode <", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeLessThanOrEqualTo(String value) {
            addCriterion("zcode <=", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeLike(String value) {
            addCriterion("zcode like", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeNotLike(String value) {
            addCriterion("zcode not like", value, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeIn(List<String> values) {
            addCriterion("zcode in", values, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeNotIn(List<String> values) {
            addCriterion("zcode not in", values, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeBetween(String value1, String value2) {
            addCriterion("zcode between", value1, value2, "zcode");
            return (Criteria) this;
        }

        public Criteria andZcodeNotBetween(String value1, String value2) {
            addCriterion("zcode not between", value1, value2, "zcode");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andAccessStateIsNull() {
            addCriterion("access_state is null");
            return (Criteria) this;
        }

        public Criteria andAccessStateIsNotNull() {
            addCriterion("access_state is not null");
            return (Criteria) this;
        }

        public Criteria andAccessStateEqualTo(String value) {
            addCriterion("access_state =", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateNotEqualTo(String value) {
            addCriterion("access_state <>", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateGreaterThan(String value) {
            addCriterion("access_state >", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateGreaterThanOrEqualTo(String value) {
            addCriterion("access_state >=", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateLessThan(String value) {
            addCriterion("access_state <", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateLessThanOrEqualTo(String value) {
            addCriterion("access_state <=", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateLike(String value) {
            addCriterion("access_state like", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateNotLike(String value) {
            addCriterion("access_state not like", value, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateIn(List<String> values) {
            addCriterion("access_state in", values, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateNotIn(List<String> values) {
            addCriterion("access_state not in", values, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateBetween(String value1, String value2) {
            addCriterion("access_state between", value1, value2, "accessState");
            return (Criteria) this;
        }

        public Criteria andAccessStateNotBetween(String value1, String value2) {
            addCriterion("access_state not between", value1, value2, "accessState");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIsNull() {
            addCriterion("upload_status is null");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIsNotNull() {
            addCriterion("upload_status is not null");
            return (Criteria) this;
        }

        public Criteria andUploadStatusEqualTo(Short value) {
            addCriterion("upload_status =", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotEqualTo(Short value) {
            addCriterion("upload_status <>", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusGreaterThan(Short value) {
            addCriterion("upload_status >", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("upload_status >=", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusLessThan(Short value) {
            addCriterion("upload_status <", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusLessThanOrEqualTo(Short value) {
            addCriterion("upload_status <=", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIn(List<Short> values) {
            addCriterion("upload_status in", values, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotIn(List<Short> values) {
            addCriterion("upload_status not in", values, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusBetween(Short value1, Short value2) {
            addCriterion("upload_status between", value1, value2, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotBetween(Short value1, Short value2) {
            addCriterion("upload_status not between", value1, value2, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGsdwIsNull() {
            addCriterion("gsdw is null");
            return (Criteria) this;
        }

        public Criteria andGsdwIsNotNull() {
            addCriterion("gsdw is not null");
            return (Criteria) this;
        }

        public Criteria andGsdwEqualTo(String value) {
            addCriterion("gsdw =", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwNotEqualTo(String value) {
            addCriterion("gsdw <>", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwGreaterThan(String value) {
            addCriterion("gsdw >", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwGreaterThanOrEqualTo(String value) {
            addCriterion("gsdw >=", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwLessThan(String value) {
            addCriterion("gsdw <", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwLessThanOrEqualTo(String value) {
            addCriterion("gsdw <=", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwLike(String value) {
            addCriterion("gsdw like", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwNotLike(String value) {
            addCriterion("gsdw not like", value, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwIn(List<String> values) {
            addCriterion("gsdw in", values, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwNotIn(List<String> values) {
            addCriterion("gsdw not in", values, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwBetween(String value1, String value2) {
            addCriterion("gsdw between", value1, value2, "gsdw");
            return (Criteria) this;
        }

        public Criteria andGsdwNotBetween(String value1, String value2) {
            addCriterion("gsdw not between", value1, value2, "gsdw");
            return (Criteria) this;
        }


        public Criteria andWarningStatusIsNull() {
            addCriterion("warning_status is null");
            return (Criteria) this;
        }

        public Criteria andWarningStatusIsNotNull() {
            addCriterion("warning_status is not null");
            return (Criteria) this;
        }

        public Criteria andWarningStatusEqualTo(Integer value) {
            addCriterion("warning_status =", value, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusNotEqualTo(Integer value) {
            addCriterion("warning_status <>", value, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusGreaterThan(Integer value) {
            addCriterion("warning_status >", value, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("warning_status >=", value, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusLessThan(Integer value) {
            addCriterion("warning_status <", value, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusLessThanOrEqualTo(Integer value) {
            addCriterion("warning_status <=", value, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusIn(List<Integer> values) {
            addCriterion("warning_status in", values, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusNotIn(List<Integer> values) {
            addCriterion("warning_status not in", values, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusBetween(Integer value1, Integer value2) {
            addCriterion("warning_status between", value1, value2, "warning_status");
            return (Criteria) this;
        }

        public Criteria andWarningStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("warning_status not between", value1, value2, "warning_status");
            return (Criteria) this;
        }


        public Criteria andreceiveViolateCodeIsNull() {
            addCriterion("receive_violate_code is null");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeIsNotNull() {
            addCriterion("receive_violate_code is not null");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeEqualTo(String value) {
            addCriterion("receive_violate_code =", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeNotEqualTo(String value) {
            addCriterion("receive_violate_code <>", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeGreaterThan(String value) {
            addCriterion("receive_violate_code >", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("receive_violate_code >=", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeLessThan(String value) {
            addCriterion("receive_violate_code <", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeLessThanOrEqualTo(String value) {
            addCriterion("receive_violate_code <=", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeLike(String value) {
            addCriterion("receive_violate_code like", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeNotLike(String value) {
            addCriterion("receive_violate_code not like", value, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeIn(List<String> values) {
            addCriterion("receive_violate_code in", values, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeNotIn(List<String> values) {
            addCriterion("receive_violate_code not in", values, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeBetween(String value1, String value2) {
            addCriterion("receive_violate_code between", value1, value2, "receive_violate_code");
            return (Criteria) this;
        }

        public Criteria andreceiveViolateCodeNotBetween(String value1, String value2) {
            addCriterion("receive_violate_code not between", value1, value2, "receive_violate_code");
            return (Criteria) this;
        }

    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
