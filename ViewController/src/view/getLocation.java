package view;

import java.text.SimpleDateFormat;

import java.util.Date;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

public class getLocation {
    public getLocation() {
    }

    public void getLocation(ClientEvent clientEvent) {
        // Add event code here...
        DCBindingContainer dcBindings =
                           (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                       OperationBinding op = dcBindings.getOperationBinding("CreateInsert");
                       op.execute();
               DCIteratorBinding iteratorBinding = (DCIteratorBinding)dcBindings.get("MmpTrainingCheckInView1Iterator");
                       RowSetIterator rowSetIterator = iteratorBinding.getRowSetIterator();
                       Row r = rowSetIterator.getCurrentRow();
                       r.setAttribute("Longitude", clientEvent.getParameters().get("long"));
                       r.setAttribute("Latitude", clientEvent.getParameters().get("lat"));
               SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

               String dateString = format.format( new Date()   );
               
               r.setAttribute("Dated", dateString);
                       r.setAttribute("MmpTrainingCheckInId", 00);
                       
                       //////////////////////////////
                              
                       
    }
}
