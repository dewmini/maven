

package nicApp;

import org.joda.time.*;

public class nicInterpreter {

    private String nic;
    private String details;

    public nic createNic(String nic) throws mavelException {

        try {
            nic NIC=new nic(nic);
            return NIC;

        } catch (Exception ex) {
            throw new mavelException("Invalid Input");
        }
    }
    
    
    public void details() throws mavelException{

        int year,month,date,temp;
        boolean isVoter;
        String gender;
        
        
        try{
            year = Integer.parseInt("19"+nic.substring(0, 2));

            if((year>2013)||(year<1900)){
                throw new mavelException("Invalid first two digiits");
            }

            else{
                 temp=Integer.parseInt(nic.substring(2, 5));

                if(temp>=500){
                    gender = "Female";
                    temp=temp-500;
                }
                else{
                    gender = "Male";
                }
                
                DateTime birthday = new DateTime(year,1,1,0,0);
                birthday = birthday.plusDays(temp-2);
                month = birthday.getMonthOfYear();
                date = birthday.getDayOfMonth();
                
                if((2013-year)>=18){
                    isVoter = true;
                }
                else{
                    isVoter = false;
                }               
                details = "NIC[birthday=Birthday[year ="+year+" month = "+month+" date ="+date+" ],Gender = "+gender+",isVoter = "+isVoter+"]";
            }         
        }
        catch(mavelException e){
            throw e;
        }
    }

    public String showDetails(nic NIC) throws mavelException {
        nic = NIC.getNic();
        details();
        return details;
    }
}
