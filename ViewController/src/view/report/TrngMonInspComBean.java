package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.domain.Number;

import view.DatabaseConnection.DatabaseConnection;

public class TrngMonInspComBean {
    public TrngMonInspComBean() {
        System.out.println("MMP Trng Mon Insp Com Report");
    }

    private RichSelectOneChoice selected_module;
    private RichSelectOneChoice selected_phase;
    private RichSelectOneChoice format_type;

    private static Number  gotModule;
    private static Number  gotPhase;
    private static String gotFormat = "";
    
    public String get_report() {
        // Add event code here...
        
        gotModule = (Number)this.getselected_module().getValue(); // To recieve value from UI InputText Component
        gotPhase = (Number)this.getselected_phase().getValue();
        gotFormat = (String)this.getFormat_type().getValue();
        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
        String url = "";
        
        if(gotModule != null){
            reportBean.setReportParameter("P_Module_id", gotModule.toString());
        }        
        if(gotPhase != null){
            reportBean.setReportParameter("P_Phase_id", gotPhase.toString());
        } 
        
        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {
            
            
                              reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/MMP_Reports/Trng_Mon_Insp_Com&");
        } 
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        gotFormat); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);

        return null;
    }
    
    
    
    public String showMessage(String msgs) {
        String messageText = msgs;
        FacesMessage fm = new FacesMessage(messageText);
        /**
             * set the type of the message.
             * Valid types: error, fatal,info,warning
             */
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        return null;
    }
    
    

    public void setFormat_type(RichSelectOneChoice format_type) {
        this.format_type = format_type;
    }

    public RichSelectOneChoice getFormat_type() {
        return format_type;
    }
    
    public void setselected_module(RichSelectOneChoice get_selected_module) {
        this.selected_module = get_selected_module;
    }

    public RichSelectOneChoice getselected_module() {
        return selected_module;
    }
    
    public void setselected_phase(RichSelectOneChoice get_selected_phase) {
        this.selected_phase = get_selected_phase;
    }

    public RichSelectOneChoice getselected_phase() {
        return selected_phase;
    }
}
