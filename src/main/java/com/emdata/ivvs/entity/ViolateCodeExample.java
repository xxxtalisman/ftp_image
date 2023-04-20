package com.emdata.ivvs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViolateCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ViolateCodeExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(Long value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(Long value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(Long value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(Long value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(Long value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(Long value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<Long> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<Long> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(Long value1, Long value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(Long value1, Long value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeIsNull() {
            addCriterion("internal_violate_type is null");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeIsNotNull() {
            addCriterion("internal_violate_type is not null");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeEqualTo(Integer value) {
            addCriterion("internal_violate_type =", value, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeNotEqualTo(Integer value) {
            addCriterion("internal_violate_type <>", value, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeGreaterThan(Integer value) {
            addCriterion("internal_violate_type >", value, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("internal_violate_type >=", value, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeLessThan(Integer value) {
            addCriterion("internal_violate_type <", value, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("internal_violate_type <=", value, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeIn(List<Integer> values) {
            addCriterion("internal_violate_type in", values, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeNotIn(List<Integer> values) {
            addCriterion("internal_violate_type not in", values, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeBetween(Integer value1, Integer value2) {
            addCriterion("internal_violate_type between", value1, value2, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andInternalViolateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("internal_violate_type not between", value1, value2, "internalViolateType");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeIsNull() {
            addCriterion("secondary_code is null");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeIsNotNull() {
            addCriterion("secondary_code is not null");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeEqualTo(String value) {
            addCriterion("secondary_code =", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeNotEqualTo(String value) {
            addCriterion("secondary_code <>", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeGreaterThan(String value) {
            addCriterion("secondary_code >", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("secondary_code >=", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeLessThan(String value) {
            addCriterion("secondary_code <", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeLessThanOrEqualTo(String value) {
            addCriterion("secondary_code <=", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeLike(String value) {
            addCriterion("secondary_code like", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeNotLike(String value) {
            addCriterion("secondary_code not like", value, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeIn(List<String> values) {
            addCriterion("secondary_code in", values, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeNotIn(List<String> values) {
            addCriterion("secondary_code not in", values, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeBetween(String value1, String value2) {
            addCriterion("secondary_code between", value1, value2, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andSecondaryCodeNotBetween(String value1, String value2) {
            addCriterion("secondary_code not between", value1, value2, "secondaryCode");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNull() {
            addCriterion("is_send is null");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNotNull() {
            addCriterion("is_send is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendEqualTo(Byte value) {
            addCriterion("is_send =", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotEqualTo(Byte value) {
            addCriterion("is_send <>", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThan(Byte value) {
            addCriterion("is_send >", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_send >=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThan(Byte value) {
            addCriterion("is_send <", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThanOrEqualTo(Byte value) {
            addCriterion("is_send <=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendIn(List<Byte> values) {
            addCriterion("is_send in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotIn(List<Byte> values) {
            addCriterion("is_send not in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendBetween(Byte value1, Byte value2) {
            addCriterion("is_send between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotBetween(Byte value1, Byte value2) {
            addCriterion("is_send not between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNull() {
            addCriterion("is_auto is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNotNull() {
            addCriterion("is_auto is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoEqualTo(Byte value) {
            addCriterion("is_auto =", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotEqualTo(Byte value) {
            addCriterion("is_auto <>", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThan(Byte value) {
            addCriterion("is_auto >", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_auto >=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThan(Byte value) {
            addCriterion("is_auto <", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThanOrEqualTo(Byte value) {
            addCriterion("is_auto <=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoIn(List<Byte> values) {
            addCriterion("is_auto in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotIn(List<Byte> values) {
            addCriterion("is_auto not in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoBetween(Byte value1, Byte value2) {
            addCriterion("is_auto between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotBetween(Byte value1, Byte value2) {
            addCriterion("is_auto not between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsLpnIsNull() {
            addCriterion("is_lpn is null");
            return (Criteria) this;
        }

        public Criteria andIsLpnIsNotNull() {
            addCriterion("is_lpn is not null");
            return (Criteria) this;
        }

        public Criteria andIsLpnEqualTo(Byte value) {
            addCriterion("is_lpn =", value, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnNotEqualTo(Byte value) {
            addCriterion("is_lpn <>", value, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnGreaterThan(Byte value) {
            addCriterion("is_lpn >", value, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_lpn >=", value, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnLessThan(Byte value) {
            addCriterion("is_lpn <", value, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnLessThanOrEqualTo(Byte value) {
            addCriterion("is_lpn <=", value, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnIn(List<Byte> values) {
            addCriterion("is_lpn in", values, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnNotIn(List<Byte> values) {
            addCriterion("is_lpn not in", values, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnBetween(Byte value1, Byte value2) {
            addCriterion("is_lpn between", value1, value2, "isLpn");
            return (Criteria) this;
        }

        public Criteria andIsLpnNotBetween(Byte value1, Byte value2) {
            addCriterion("is_lpn not between", value1, value2, "isLpn");
            return (Criteria) this;
        }

        public Criteria andAlgTypeIsNull() {
            addCriterion("alg_type is null");
            return (Criteria) this;
        }

        public Criteria andAlgTypeIsNotNull() {
            addCriterion("alg_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlgTypeEqualTo(Integer value) {
            addCriterion("alg_type =", value, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeNotEqualTo(Integer value) {
            addCriterion("alg_type <>", value, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeGreaterThan(Integer value) {
            addCriterion("alg_type >", value, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("alg_type >=", value, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeLessThan(Integer value) {
            addCriterion("alg_type <", value, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeLessThanOrEqualTo(Integer value) {
            addCriterion("alg_type <=", value, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeIn(List<Integer> values) {
            addCriterion("alg_type in", values, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeNotIn(List<Integer> values) {
            addCriterion("alg_type not in", values, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeBetween(Integer value1, Integer value2) {
            addCriterion("alg_type between", value1, value2, "algType");
            return (Criteria) this;
        }

        public Criteria andAlgTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("alg_type not between", value1, value2, "algType");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Byte value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Byte value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Byte value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Byte value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Byte value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Byte> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Byte> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Byte value1, Byte value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Byte value1, Byte value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Byte value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Byte value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Byte value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Byte value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Byte value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Byte value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Byte> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Byte> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Byte value1, Byte value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Byte value1, Byte value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRegulationNameIsNull() {
            addCriterion("regulation_name is null");
            return (Criteria) this;
        }

        public Criteria andRegulationNameIsNotNull() {
            addCriterion("regulation_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegulationNameEqualTo(String value) {
            addCriterion("regulation_name =", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameNotEqualTo(String value) {
            addCriterion("regulation_name <>", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameGreaterThan(String value) {
            addCriterion("regulation_name >", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameGreaterThanOrEqualTo(String value) {
            addCriterion("regulation_name >=", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameLessThan(String value) {
            addCriterion("regulation_name <", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameLessThanOrEqualTo(String value) {
            addCriterion("regulation_name <=", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameLike(String value) {
            addCriterion("regulation_name like", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameNotLike(String value) {
            addCriterion("regulation_name not like", value, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameIn(List<String> values) {
            addCriterion("regulation_name in", values, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameNotIn(List<String> values) {
            addCriterion("regulation_name not in", values, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameBetween(String value1, String value2) {
            addCriterion("regulation_name between", value1, value2, "regulationName");
            return (Criteria) this;
        }

        public Criteria andRegulationNameNotBetween(String value1, String value2) {
            addCriterion("regulation_name not between", value1, value2, "regulationName");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeIsNull() {
            addCriterion("national_standard_code is null");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeIsNotNull() {
            addCriterion("national_standard_code is not null");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeEqualTo(String value) {
            addCriterion("national_standard_code =", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeNotEqualTo(String value) {
            addCriterion("national_standard_code <>", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeGreaterThan(String value) {
            addCriterion("national_standard_code >", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("national_standard_code >=", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeLessThan(String value) {
            addCriterion("national_standard_code <", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeLessThanOrEqualTo(String value) {
            addCriterion("national_standard_code <=", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeLike(String value) {
            addCriterion("national_standard_code like", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeNotLike(String value) {
            addCriterion("national_standard_code not like", value, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeIn(List<String> values) {
            addCriterion("national_standard_code in", values, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeNotIn(List<String> values) {
            addCriterion("national_standard_code not in", values, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeBetween(String value1, String value2) {
            addCriterion("national_standard_code between", value1, value2, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andNationalStandardCodeNotBetween(String value1, String value2) {
            addCriterion("national_standard_code not between", value1, value2, "nationalStandardCode");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeIsNull() {
            addCriterion("third_party_code is null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeIsNotNull() {
            addCriterion("third_party_code is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeEqualTo(String value) {
            addCriterion("third_party_code =", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeNotEqualTo(String value) {
            addCriterion("third_party_code <>", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeGreaterThan(String value) {
            addCriterion("third_party_code >", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("third_party_code >=", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeLessThan(String value) {
            addCriterion("third_party_code <", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeLessThanOrEqualTo(String value) {
            addCriterion("third_party_code <=", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeLike(String value) {
            addCriterion("third_party_code like", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeNotLike(String value) {
            addCriterion("third_party_code not like", value, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeIn(List<String> values) {
            addCriterion("third_party_code in", values, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeNotIn(List<String> values) {
            addCriterion("third_party_code not in", values, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeBetween(String value1, String value2) {
            addCriterion("third_party_code between", value1, value2, "thirdPartyCode");
            return (Criteria) this;
        }

        public Criteria andThirdPartyCodeNotBetween(String value1, String value2) {
            addCriterion("third_party_code not between", value1, value2, "thirdPartyCode");
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

        public Criteria andCvmValueIsNull() {
            addCriterion("cvm_value is null");
            return (Criteria) this;
        }

        public Criteria andCvmValueIsNotNull() {
            addCriterion("cvm_value is not null");
            return (Criteria) this;
        }

        public Criteria andCvmValueEqualTo(String value) {
            addCriterion("cvm_value =", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueNotEqualTo(String value) {
            addCriterion("cvm_value <>", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueGreaterThan(String value) {
            addCriterion("cvm_value >", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueGreaterThanOrEqualTo(String value) {
            addCriterion("cvm_value >=", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueLessThan(String value) {
            addCriterion("cvm_value <", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueLessThanOrEqualTo(String value) {
            addCriterion("cvm_value <=", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueLike(String value) {
            addCriterion("cvm_value like", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueNotLike(String value) {
            addCriterion("cvm_value not like", value, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueIn(List<String> values) {
            addCriterion("cvm_value in", values, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueNotIn(List<String> values) {
            addCriterion("cvm_value not in", values, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueBetween(String value1, String value2) {
            addCriterion("cvm_value between", value1, value2, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andCvmValueNotBetween(String value1, String value2) {
            addCriterion("cvm_value not between", value1, value2, "cvmValue");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusIsNull() {
            addCriterion("receive_status is null");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusIsNotNull() {
            addCriterion("receive_status is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusEqualTo(Integer value) {
            addCriterion("receive_status =", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusNotEqualTo(Integer value) {
            addCriterion("receive_status <>", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusGreaterThan(Integer value) {
            addCriterion("receive_status >", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_status >=", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusLessThan(Integer value) {
            addCriterion("receive_status <", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("receive_status <=", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusIn(List<Integer> values) {
            addCriterion("receive_status in", values, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusNotIn(List<Integer> values) {
            addCriterion("receive_status not in", values, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusBetween(Integer value1, Integer value2) {
            addCriterion("receive_status between", value1, value2, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_status not between", value1, value2, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusIsNull() {
            addCriterion("monitor_status is null");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusIsNotNull() {
            addCriterion("monitor_status is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusEqualTo(Integer value) {
            addCriterion("monitor_status =", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusNotEqualTo(Integer value) {
            addCriterion("monitor_status <>", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusGreaterThan(Integer value) {
            addCriterion("monitor_status >", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("monitor_status >=", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusLessThan(Integer value) {
            addCriterion("monitor_status <", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusLessThanOrEqualTo(Integer value) {
            addCriterion("monitor_status <=", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusIn(List<Integer> values) {
            addCriterion("monitor_status in", values, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusNotIn(List<Integer> values) {
            addCriterion("monitor_status not in", values, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusBetween(Integer value1, Integer value2) {
            addCriterion("monitor_status between", value1, value2, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("monitor_status not between", value1, value2, "monitorStatus");
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