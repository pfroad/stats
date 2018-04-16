package com.airparking.azkaban.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016-05-19.
 */
@Table(name = "ap_lease")
public class Order implements Serializable {
    public final static int KEEP_ORDER_TIME_MINUTE = 15;
    public final static int PRE_PAY_EXPIRE_MS = 30000;
    public final static String ORDER_PRE_PAY_PREFIX = "order:prepay:tradeNo:";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "space_id")
    private Long spaceId;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "park_id")
    private Long parkId;
    // 订单号
    @Column(name = "identifier")
    private String identifier;

    @Column(name = "type")
    private String type;

    @Column(name = "plate_no")
    private String plateNo;

    @Column(name = "reserve_start_date")
    private Date reserveStartDate;

    @Column(name = "reserve_end_date")
    private Date reserveEndDate;

    @Column(name = "actual_start_date")
    private Date actualStartDate;

    @Column(name = "actual_end_date")
    private Date actualEndDate;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "execution_status")
    private String executionStatus;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_log_id")
    private Long paymentLogId;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "paid_amount")
    private Integer paidAmount;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name = "additional_amount")
    private Integer additionalAmount;
    
    @Column(name = "book_fee")
    private Integer bookFee;

    @Column(name = "lessor")
    private Long lessor;

    @Column(name = "renter")
    private Long renter;

    @Column(name = "cancelled_date")
    private Date cancelledDate;

    @Column(name = "settlement_status")
    private String settlementStatus;

    @Column(name = "settlement_error_msg")
    private String settlementErrorMsg;

    @Column(name = "available_start_date")
    private Date availableStartDate;

    @Column(name = "available_end_date")
    private Date availableEndDate;

    @Column(name = "timeout_seconds")
    private Integer timeoutSeconds;

    @Column(name = "transaction_log_id")
    private Long transactionLogId;

    @Column(name = "payment_attempts")
    private Integer paymentAttempts;

    @Column(name = "sent_will_overtime_msg")
    private Boolean sentWillOvertimeMsg;

    @Column(name = "refund_amount")
    private Integer refundAmount;

    @Column(name = "reduce_amount")
    private Integer reduceAmount;

    @Column(name = "blocked")
    private Boolean blocked;

    @Column(name = "blocked_date")
    private Date blockedDate;

    @Column(name = "blocked_reasoncode")
    private Integer blockedReasoncode;

    @Column(name = "blocked_detail")
    private String blockedDetail;

    @Column(name = "blocked_operation")
    private String blockedOperation;

    @Column(name = "audit_status")
    private String auditStatus;

    @Column(name = "audit_reasoncode")
    private Integer auditReasoncode;

    @Column(name = "audit_detail")
    private String auditDetail;

    @Column(name = "audit_reduce_amount")
    private Integer auditReduceAmount;

    @Column(name = "audit_refund_amount")
    private Integer auditRefundAmount;

    @Column(name = "original_amount")
    private Integer originalAmount;

    @Column(name = "original_end_date")
    private Date originalEndDate;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "mark_status")
    private String markStatus;

    @Column(name = "version")
    private Long version;

    @Column(name = "channel_id")
    private Long channelId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name= "parking_no")
    private String parkingNo;


	public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setSpaceId(Long spaceId){
        this.spaceId = spaceId;
    }

    public Long getSpaceId(){
        return this.spaceId;
    }

    public void setPostId(Long postId){
        this.postId = postId;
    }

    public Long getPostId(){
        return this.postId;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier(){
        return this.identifier;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setPlateNo(String plateNo){
        this.plateNo = plateNo;
    }

    public String getPlateNo(){
        return this.plateNo;
    }

    public void setReserveStartDate(Date reserveStartDate){
        this.reserveStartDate = reserveStartDate;
    }

    public Date getReserveStartDate(){
        return this.reserveStartDate;
    }

    public void setReserveEndDate(Date reserveEndDate){
        this.reserveEndDate = reserveEndDate;
    }

    public Date getReserveEndDate(){
        return this.reserveEndDate;
    }

    public void setActualStartDate(Date actualStartDate){
        this.actualStartDate = actualStartDate;
    }

    public Date getActualStartDate(){
        return this.actualStartDate;
    }

    public void setActualEndDate(Date actualEndDate){
        this.actualEndDate = actualEndDate;
    }

    public Date getActualEndDate(){
        return this.actualEndDate;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public Date getCreatedDate(){
        return this.createdDate;
    }

    public void setExecutionStatus(String executionStatus){
        this.executionStatus = executionStatus;
    }

    public String getExecutionStatus(){
        return this.executionStatus;
    }

    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus(){
        return this.paymentStatus;
    }

    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }

    public String getPaymentType(){
        return this.paymentType;
    }

    public void setPaymentDate(Date paymentDate){
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate(){
        return this.paymentDate;
    }

    public void setPaymentLogId(Long paymentLogId){
        this.paymentLogId = paymentLogId;
    }

    public Long getPaymentLogId(){
        return this.paymentLogId;
    }

    public void setTotalAmount(Integer totalAmount){
        this.totalAmount = totalAmount;
    }

    public Integer getTotalAmount(){
        return this.totalAmount;
    }

    public void setPaidAmount(Integer paidAmount){
        this.paidAmount = paidAmount;
    }

    public Integer getPaidAmount(){
        return this.paidAmount;
    }

    public void setDiscountAmount(Integer discountAmount){
        this.discountAmount = discountAmount;
    }

    public Integer getDiscountAmount(){
        return this.discountAmount;
    }

    public Integer getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(Integer additionalAmount) {
        this.additionalAmount = additionalAmount;
    }
    
    public Integer getBookFee() {
		return bookFee;
	}

	public void setBookFee(Integer bookFee) {
		this.bookFee = bookFee;
	}

	public void setLessor(Long lessor){
        this.lessor = lessor;
    }

    public Long getLessor(){
        return this.lessor;
    }

    public void setRenter(Long renter){
        this.renter = renter;
    }

    public Long getRenter(){
        return this.renter;
    }

    public void setCancelledDate(Date cancelledDate){
        this.cancelledDate = cancelledDate;
    }

    public Date getCancelledDate(){
        return this.cancelledDate;
    }

    public void setSettlementStatus(String settlementStatus){
        this.settlementStatus = settlementStatus;
    }

    public String getSettlementStatus(){
        return this.settlementStatus;
    }

    public void setSettlementErrorMsg(String settlementErrorMsg){
        this.settlementErrorMsg = settlementErrorMsg;
    }

    public String getSettlementErrorMsg(){
        return this.settlementErrorMsg;
    }

    public void setAvailableStartDate(Date availableStartDate){
        this.availableStartDate = availableStartDate;
    }

    public Date getAvailableStartDate(){
        return this.availableStartDate;
    }

    public void setAvailableEndDate(Date availableEndDate){
        this.availableEndDate = availableEndDate;
    }

    public Date getAvailableEndDate(){
        return this.availableEndDate;
    }

    public void setTimeoutSeconds(Integer timeoutSeconds){
        this.timeoutSeconds = timeoutSeconds;
    }

    public Integer getTimeoutSeconds(){
        return this.timeoutSeconds;
    }

    public void setTransactionLogId(Long transactionLogId){
        this.transactionLogId = transactionLogId;
    }

    public Long getTransactionLogId(){
        return this.transactionLogId;
    }

    public void setPaymentAttempts(Integer paymentAttempts){
        this.paymentAttempts = paymentAttempts;
    }

    public Integer getPaymentAttempts(){
        return this.paymentAttempts;
    }

    public void setSentWillOvertimeMsg(Boolean sentWillOvertimeMsg){
        this.sentWillOvertimeMsg = sentWillOvertimeMsg;
    }

    public Boolean getSentWillOvertimeMsg(){
        return this.sentWillOvertimeMsg;
    }

    public void setRefundAmount(Integer refundAmount){
        this.refundAmount = refundAmount;
    }

    public Integer getRefundAmount(){
        return this.refundAmount;
    }

    public void setReduceAmount(Integer reduceAmount){
        this.reduceAmount = reduceAmount;
    }

    public Integer getReduceAmount(){
        return this.reduceAmount;
    }

    public void setBlocked(Boolean blocked){
        this.blocked = blocked;
    }

    public Boolean getBlocked(){
        return this.blocked;
    }

    public void setBlockedDate(Date blockedDate){
        this.blockedDate = blockedDate;
    }

    public Date getBlockedDate(){
        return this.blockedDate;
    }

    public void setBlockedReasoncode(Integer blockedReasoncode){
        this.blockedReasoncode = blockedReasoncode;
    }

    public Integer getBlockedReasoncode(){
        return this.blockedReasoncode;
    }

    public void setBlockedDetail(String blockedDetail){
        this.blockedDetail = blockedDetail;
    }

    public String getBlockedDetail(){
        return this.blockedDetail;
    }

    public void setBlockedOperation(String blockedOperation){
        this.blockedOperation = blockedOperation;
    }

    public String getBlockedOperation(){
        return this.blockedOperation;
    }

    public void setAuditStatus(String auditStatus){
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus(){
        return this.auditStatus;
    }

    public void setAuditReasoncode(Integer auditReasoncode){
        this.auditReasoncode = auditReasoncode;
    }

    public Integer getAuditReasoncode(){
        return this.auditReasoncode;
    }

    public void setAuditDetail(String auditDetail){
        this.auditDetail = auditDetail;
    }

    public String getAuditDetail(){
        return this.auditDetail;
    }

    public void setAuditReduceAmount(Integer auditReduceAmount){
        this.auditReduceAmount = auditReduceAmount;
    }

    public Integer getAuditReduceAmount(){
        return this.auditReduceAmount;
    }

    public void setAuditRefundAmount(Integer auditRefundAmount){
        this.auditRefundAmount = auditRefundAmount;
    }

    public Integer getAuditRefundAmount(){
        return this.auditRefundAmount;
    }

    public void setOriginalAmount(Integer originalAmount){
        this.originalAmount = originalAmount;
    }

    public Integer getOriginalAmount(){
        return this.originalAmount;
    }

    public void setOriginalEndDate(Date originalEndDate){
        this.originalEndDate = originalEndDate;
    }

    public Date getOriginalEndDate(){
        return this.originalEndDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate){
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getLastModifiedDate(){
        return this.lastModifiedDate;
    }

    public void setMarkStatus(String markStatus){
        this.markStatus = markStatus;
    }

    public String getMarkStatus(){
        return this.markStatus;
    }

    public void setVersion(Long version){
        this.version = version;
    }

    public Long getVersion(){
        return this.version;
    }

    public void setChannelId(Long channelId){
        this.channelId = channelId;
    }

    public Long getChannelId(){
        return this.channelId;
    }

    public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public enum OrderStatus {
        RESERVED(0, "RESERVED"),
        CANCELLED(1, "CANCELLED"),
        PROCESSING(2, "PROCESSING"),
        COMPLETED(4, "COMPLETED"),

        UNPAID(8, "UNPAID"),
        PRE_PAID(4096, "PRE_PAID"),
        PAID(16, "PAID"),

        SETTLEMENT_PENDING(32, "PENDING"),
        SETTLEMENT_COMPLETED(64, "COMPLETED"),

        MARK(128, "MARK"),
        BLOCKED(256, "BLOCKED"),

        REJECT(512, "REJECT"),
        AUDITING(1024, "AUDITING"),
        AUDITED(2048, "AUDITED"),
        CLOSED(8192,"CLOSED");


        private int value;
        private String str;

        OrderStatus(int value, String str) {
            this.value = value;
            this.str = str;
        }

        public int getValue() {
            return value;
        }

        public String getStr() {
            return str;
        }

        public static OrderStatus getStatusByStr(String str) {
            for (OrderStatus status : OrderStatus.values()) {
                if (status.getStr().equals(str)) {
                    return status;
                }
            }

            return null;
        }

        public static OrderStatus getStatus(int val) {
            for (OrderStatus status : OrderStatus.values()) {
                if (status.getValue() == val) {
                    return status;
                }
            }

            return null;
        }
    }

    public enum Type {
        REAL_TIME(1, "REAL_TIME"),
        IMPROMPTU(2 , "IMPROMPTU"),
        MONTH_RENT(4, "MONTH_RENT"),
        AUTO_START(1 << 3 , "AUTO_START");
        private Integer value;
        private  String desc;

        Type(Integer val, String str) {
            this.value = val;
            this.desc = str;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}