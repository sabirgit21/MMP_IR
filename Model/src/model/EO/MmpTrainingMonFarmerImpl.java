package model.EO;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jan 06 17:16:08 PKT 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MmpTrainingMonFarmerImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        MmpTrainingMonFarmerId,
        MmpTrainingMonInspId,
        FarmerRegId,
        FarmerStatus,
        CreatedDate,
        CreatedBy,
        UpdatedDate,
        UpdatedBy,
        VerSource,
        PerChange,
        Remarks,
        LandDiff,
        VerLandAcre,
        VerLandUnderOrch,
        ArivalTime,
        LeftTime,
        MmpTrainingMonInsp,
        TblFarmerReg;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int MMPTRAININGMONFARMERID = AttributesEnum.MmpTrainingMonFarmerId.index();
    public static final int MMPTRAININGMONINSPID = AttributesEnum.MmpTrainingMonInspId.index();
    public static final int FARMERREGID = AttributesEnum.FarmerRegId.index();
    public static final int FARMERSTATUS = AttributesEnum.FarmerStatus.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int VERSOURCE = AttributesEnum.VerSource.index();
    public static final int PERCHANGE = AttributesEnum.PerChange.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int LANDDIFF = AttributesEnum.LandDiff.index();
    public static final int VERLANDACRE = AttributesEnum.VerLandAcre.index();
    public static final int VERLANDUNDERORCH = AttributesEnum.VerLandUnderOrch.index();
    public static final int ARIVALTIME = AttributesEnum.ArivalTime.index();
    public static final int LEFTTIME = AttributesEnum.LeftTime.index();
    public static final int MMPTRAININGMONINSP = AttributesEnum.MmpTrainingMonInsp.index();
    public static final int TBLFARMERREG = AttributesEnum.TblFarmerReg.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MmpTrainingMonFarmerImpl() {
    }

    /**
     * Gets the attribute value for MmpTrainingMonFarmerId, using the alias name MmpTrainingMonFarmerId.
     * @return the value of MmpTrainingMonFarmerId
     */
    public BigDecimal getMmpTrainingMonFarmerId() {
        return (BigDecimal) getAttributeInternal(MMPTRAININGMONFARMERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MmpTrainingMonFarmerId.
     * @param value value to set the MmpTrainingMonFarmerId
     */
    public void setMmpTrainingMonFarmerId(BigDecimal value) {
        setAttributeInternal(MMPTRAININGMONFARMERID, value);
    }

    /**
     * Gets the attribute value for MmpTrainingMonInspId, using the alias name MmpTrainingMonInspId.
     * @return the value of MmpTrainingMonInspId
     */
    public BigDecimal getMmpTrainingMonInspId() {
        return (BigDecimal) getAttributeInternal(MMPTRAININGMONINSPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MmpTrainingMonInspId.
     * @param value value to set the MmpTrainingMonInspId
     */
    public void setMmpTrainingMonInspId(BigDecimal value) {
        setAttributeInternal(MMPTRAININGMONINSPID, value);
    }

    /**
     * Gets the attribute value for FarmerRegId, using the alias name FarmerRegId.
     * @return the value of FarmerRegId
     */
    public BigDecimal getFarmerRegId() {
        return (BigDecimal) getAttributeInternal(FARMERREGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for FarmerRegId.
     * @param value value to set the FarmerRegId
     */
    public void setFarmerRegId(BigDecimal value) {
        setAttributeInternal(FARMERREGID, value);
    }

    /**
     * Gets the attribute value for FarmerStatus, using the alias name FarmerStatus.
     * @return the value of FarmerStatus
     */
    public String getFarmerStatus() {
        return (String) getAttributeInternal(FARMERSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for FarmerStatus.
     * @param value value to set the FarmerStatus
     */
    public void setFarmerStatus(String value) {
        setAttributeInternal(FARMERSTATUS, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public Number getCreatedBy() {
        return (Number) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for UpdatedDate, using the alias name UpdatedDate.
     * @return the value of UpdatedDate
     */
    public Timestamp getUpdatedDate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Gets the attribute value for UpdatedBy, using the alias name UpdatedBy.
     * @return the value of UpdatedBy
     */
    public Number getUpdatedBy() {
        return (Number) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for UpdatedBy.
     * @param value value to set the UpdatedBy
     */
    public void setUpdatedBy(Number value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for VerSource, using the alias name VerSource.
     * @return the value of VerSource
     */
    public String getVerSource() {
        return (String) getAttributeInternal(VERSOURCE);
    }

    /**
     * Sets <code>value</code> as the attribute value for VerSource.
     * @param value value to set the VerSource
     */
    public void setVerSource(String value) {
        setAttributeInternal(VERSOURCE, value);
    }

    /**
     * Gets the attribute value for PerChange, using the alias name PerChange.
     * @return the value of PerChange
     */
    public String getPerChange() {
        return (String) getAttributeInternal(PERCHANGE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PerChange.
     * @param value value to set the PerChange
     */
    public void setPerChange(String value) {
        setAttributeInternal(PERCHANGE, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the value of Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for LandDiff, using the alias name LandDiff.
     * @return the value of LandDiff
     */
    public String getLandDiff() {
        return (String) getAttributeInternal(LANDDIFF);
    }

    /**
     * Sets <code>value</code> as the attribute value for LandDiff.
     * @param value value to set the LandDiff
     */
    public void setLandDiff(String value) {
        setAttributeInternal(LANDDIFF, value);
    }

    /**
     * Gets the attribute value for VerLandAcre, using the alias name VerLandAcre.
     * @return the value of VerLandAcre
     */
    public BigDecimal getVerLandAcre() {
        return (BigDecimal) getAttributeInternal(VERLANDACRE);
    }

    /**
     * Sets <code>value</code> as the attribute value for VerLandAcre.
     * @param value value to set the VerLandAcre
     */
    public void setVerLandAcre(BigDecimal value) {
        setAttributeInternal(VERLANDACRE, value);
    }

    /**
     * Gets the attribute value for VerLandUnderOrch, using the alias name VerLandUnderOrch.
     * @return the value of VerLandUnderOrch
     */
    public BigDecimal getVerLandUnderOrch() {
        return (BigDecimal) getAttributeInternal(VERLANDUNDERORCH);
    }

    /**
     * Sets <code>value</code> as the attribute value for VerLandUnderOrch.
     * @param value value to set the VerLandUnderOrch
     */
    public void setVerLandUnderOrch(BigDecimal value) {
        setAttributeInternal(VERLANDUNDERORCH, value);
    }

    /**
     * Gets the attribute value for ArivalTime, using the alias name ArivalTime.
     * @return the value of ArivalTime
     */
    public Timestamp getArivalTime() {
        return (Timestamp) getAttributeInternal(ARIVALTIME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ArivalTime.
     * @param value value to set the ArivalTime
     */
    public void setArivalTime(Timestamp value) {
        setAttributeInternal(ARIVALTIME, value);
    }

    /**
     * Gets the attribute value for LeftTime, using the alias name LeftTime.
     * @return the value of LeftTime
     */
    public Timestamp getLeftTime() {
        return (Timestamp) getAttributeInternal(LEFTTIME);
    }

    /**
     * Sets <code>value</code> as the attribute value for LeftTime.
     * @param value value to set the LeftTime
     */
    public void setLeftTime(Timestamp value) {
        setAttributeInternal(LEFTTIME, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getMmpTrainingMonInsp() {
        return (EntityImpl) getAttributeInternal(MMPTRAININGMONINSP);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setMmpTrainingMonInsp(EntityImpl value) {
        setAttributeInternal(MMPTRAININGMONINSP, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getTblFarmerReg() {
        return (EntityImpl) getAttributeInternal(TBLFARMERREG);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setTblFarmerReg(EntityImpl value) {
        setAttributeInternal(TBLFARMERREG, value);
    }

    /**
     * @param mmpTrainingMonFarmerId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal mmpTrainingMonFarmerId) {
        return new Key(new Object[] { mmpTrainingMonFarmerId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.EO.MmpTrainingMonFarmer");
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        Number loginId = null;
           try {
               loginId = new Number((String) ADFContext.getCurrent().getSessionScope().get("sessRID"));
           } catch(Exception ex) {
               ex.printStackTrace();
           }
           
           if (operation == DML_INSERT) {
               setCreatedBy(loginId);
               setUpdatedBy(loginId);
               } else if(operation == DML_UPDATE) {
               setUpdatedBy(loginId);
           }
        super.doDML(operation, e);
    }
}
