package com.commerce.mall.model;

import java.util.ArrayList;
import java.util.List;

public class TmsFoodPicsExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmsFoodPicsExample() {
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

        public Criteria andPicIdIsNull() {
            addCriterion("pic_id is null");
            return (Criteria) this;
        }

        public Criteria andPicIdIsNotNull() {
            addCriterion("pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdEqualTo(Integer value) {
            addCriterion("pic_id =", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotEqualTo(Integer value) {
            addCriterion("pic_id <>", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThan(Integer value) {
            addCriterion("pic_id >", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_id >=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThan(Integer value) {
            addCriterion("pic_id <", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThanOrEqualTo(Integer value) {
            addCriterion("pic_id <=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdIn(List<Integer> values) {
            addCriterion("pic_id in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotIn(List<Integer> values) {
            addCriterion("pic_id not in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdBetween(Integer value1, Integer value2) {
            addCriterion("pic_id between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_id not between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicDescIsNull() {
            addCriterion("pic_desc is null");
            return (Criteria) this;
        }

        public Criteria andPicDescIsNotNull() {
            addCriterion("pic_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPicDescEqualTo(String value) {
            addCriterion("pic_desc =", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescNotEqualTo(String value) {
            addCriterion("pic_desc <>", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescGreaterThan(String value) {
            addCriterion("pic_desc >", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescGreaterThanOrEqualTo(String value) {
            addCriterion("pic_desc >=", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescLessThan(String value) {
            addCriterion("pic_desc <", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescLessThanOrEqualTo(String value) {
            addCriterion("pic_desc <=", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescLike(String value) {
            addCriterion("pic_desc like", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescNotLike(String value) {
            addCriterion("pic_desc not like", value, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescIn(List<String> values) {
            addCriterion("pic_desc in", values, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescNotIn(List<String> values) {
            addCriterion("pic_desc not in", values, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescBetween(String value1, String value2) {
            addCriterion("pic_desc between", value1, value2, "picDesc");
            return (Criteria) this;
        }

        public Criteria andPicDescNotBetween(String value1, String value2) {
            addCriterion("pic_desc not between", value1, value2, "picDesc");
            return (Criteria) this;
        }

        public Criteria andIsMainIsNull() {
            addCriterion("is_main is null");
            return (Criteria) this;
        }

        public Criteria andIsMainIsNotNull() {
            addCriterion("is_main is not null");
            return (Criteria) this;
        }

        public Criteria andIsMainEqualTo(String value) {
            addCriterion("is_main =", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainNotEqualTo(String value) {
            addCriterion("is_main <>", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainGreaterThan(String value) {
            addCriterion("is_main >", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainGreaterThanOrEqualTo(String value) {
            addCriterion("is_main >=", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainLessThan(String value) {
            addCriterion("is_main <", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainLessThanOrEqualTo(String value) {
            addCriterion("is_main <=", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainLike(String value) {
            addCriterion("is_main like", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainNotLike(String value) {
            addCriterion("is_main not like", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainIn(List<String> values) {
            addCriterion("is_main in", values, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainNotIn(List<String> values) {
            addCriterion("is_main not in", values, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainBetween(String value1, String value2) {
            addCriterion("is_main between", value1, value2, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainNotBetween(String value1, String value2) {
            addCriterion("is_main not between", value1, value2, "isMain");
            return (Criteria) this;
        }

        public Criteria andFoodIdIsNull() {
            addCriterion("food_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodIdIsNotNull() {
            addCriterion("food_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodIdEqualTo(Integer value) {
            addCriterion("food_id =", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotEqualTo(Integer value) {
            addCriterion("food_id <>", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThan(Integer value) {
            addCriterion("food_id >", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_id >=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThan(Integer value) {
            addCriterion("food_id <", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("food_id <=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdIn(List<Integer> values) {
            addCriterion("food_id in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotIn(List<Integer> values) {
            addCriterion("food_id not in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdBetween(Integer value1, Integer value2) {
            addCriterion("food_id between", value1, value2, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("food_id not between", value1, value2, "foodId");
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