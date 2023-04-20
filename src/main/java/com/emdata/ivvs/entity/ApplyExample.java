package com.emdata.ivvs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 2019/7/2.
 */
public class ApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridIsNull() {
            addCriterion("applyUserId is null");
            return (Criteria) this;
        }

        public Criteria andApplyuseridIsNotNull() {
            addCriterion("applyUserId is not null");
            return (Criteria) this;
        }

        public Criteria andApplyuseridEqualTo(Integer value) {
            addCriterion("applyUserId =", value, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridNotEqualTo(Integer value) {
            addCriterion("applyUserId <>", value, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridGreaterThan(Integer value) {
            addCriterion("applyUserId >", value, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyUserId >=", value, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridLessThan(Integer value) {
            addCriterion("applyUserId <", value, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridLessThanOrEqualTo(Integer value) {
            addCriterion("applyUserId <=", value, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridIn(List<Integer> values) {
            addCriterion("applyUserId in", values, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridNotIn(List<Integer> values) {
            addCriterion("applyUserId not in", values, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridBetween(Integer value1, Integer value2) {
            addCriterion("applyUserId between", value1, value2, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplyuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("applyUserId not between", value1, value2, "applyuserid");
            return (Criteria) this;
        }

        public Criteria andApplynumberIsNull() {
            addCriterion("applyNumber is null");
            return (Criteria) this;
        }

        public Criteria andApplynumberIsNotNull() {
            addCriterion("applyNumber is not null");
            return (Criteria) this;
        }

        public Criteria andApplynumberEqualTo(Integer value) {
            addCriterion("applyNumber =", value, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberNotEqualTo(Integer value) {
            addCriterion("applyNumber <>", value, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberGreaterThan(Integer value) {
            addCriterion("applyNumber >", value, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyNumber >=", value, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberLessThan(Integer value) {
            addCriterion("applyNumber <", value, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberLessThanOrEqualTo(Integer value) {
            addCriterion("applyNumber <=", value, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberIn(List<Integer> values) {
            addCriterion("applyNumber in", values, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberNotIn(List<Integer> values) {
            addCriterion("applyNumber not in", values, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberBetween(Integer value1, Integer value2) {
            addCriterion("applyNumber between", value1, value2, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplynumberNotBetween(Integer value1, Integer value2) {
            addCriterion("applyNumber not between", value1, value2, "applynumber");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNull() {
            addCriterion("applyType is null");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNotNull() {
            addCriterion("applyType is not null");
            return (Criteria) this;
        }

        public Criteria andApplytypeEqualTo(Integer value) {
            addCriterion("applyType =", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotEqualTo(Integer value) {
            addCriterion("applyType <>", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThan(Integer value) {
            addCriterion("applyType >", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyType >=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThan(Integer value) {
            addCriterion("applyType <", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThanOrEqualTo(Integer value) {
            addCriterion("applyType <=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeIn(List<Integer> values) {
            addCriterion("applyType in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotIn(List<Integer> values) {
            addCriterion("applyType not in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeBetween(Integer value1, Integer value2) {
            addCriterion("applyType between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("applyType not between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("applyDate is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("applyDate is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(Date value) {
            addCriterion("applyDate =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(Date value) {
            addCriterion("applyDate <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(Date value) {
            addCriterion("applyDate >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(Date value) {
            addCriterion("applyDate >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(Date value) {
            addCriterion("applyDate <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(Date value) {
            addCriterion("applyDate <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<Date> values) {
            addCriterion("applyDate in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<Date> values) {
            addCriterion("applyDate not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(Date value1, Date value2) {
            addCriterion("applyDate between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(Date value1, Date value2) {
            addCriterion("applyDate not between", value1, value2, "applydate");
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

        public Criteria andApplyisviolateIsNull() {
            addCriterion("applyIsviolate is null");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateIsNotNull() {
            addCriterion("applyIsviolate is not null");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateEqualTo(Integer value) {
            addCriterion("applyIsviolate =", value, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateNotEqualTo(Integer value) {
            addCriterion("applyIsviolate <>", value, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateGreaterThan(Integer value) {
            addCriterion("applyIsviolate >", value, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyIsviolate >=", value, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateLessThan(Integer value) {
            addCriterion("applyIsviolate <", value, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateLessThanOrEqualTo(Integer value) {
            addCriterion("applyIsviolate <=", value, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateIn(List<Integer> values) {
            addCriterion("applyIsviolate in", values, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateNotIn(List<Integer> values) {
            addCriterion("applyIsviolate not in", values, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateBetween(Integer value1, Integer value2) {
            addCriterion("applyIsviolate between", value1, value2, "applyisviolate");
            return (Criteria) this;
        }

        public Criteria andApplyisviolateNotBetween(Integer value1, Integer value2) {
            addCriterion("applyIsviolate not between", value1, value2, "applyisviolate");
            return (Criteria) this;
        }
    }

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
