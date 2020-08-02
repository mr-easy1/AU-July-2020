interface Telephone
{
    public void dial(Integer number);  // For dialing the number
    public void recieve(); // For receiving the number 
    public void endCall();  // Ending the Call
    public void isRinging();   // function for Ringing
    public void pickUp();   // Function for Picking up
}

interface Connection{
    public boolean isConnected(); 
    public boolean isPickedUp(); 
    
}

class demoPhone implements Telephone,Connection
{
    public boolean Connected;
    public boolean PickedUp;

    public demoPhone() {        
        Connected = false;
        PickedUp = false;
    }
    
       
    @Override
    public void dial(Integer number) {   
            System.out.println("Dialing to "+number);   
    }

    @Override
    public void isRinging() {
        System.out.println("Ringing..........");
        
    }

    @Override
    public void recieve() {
        isRinging();
        pickUp();
        Connected= true;
        System.out.println("Recieved call");
    }

    @Override
    public void endCall() {
        PickedUp = false;
        Connected = false;
        System.out.println("Ending the call");
    }

    @Override
    public boolean isConnected() {
        return Connected;
    }

    @Override
    public boolean isPickedUp() {
        return PickedUp;
    }


    @Override
    public void pickUp() {
        
        PickedUp = true;
        System.out.println("Call gets picked up");
    }


}

 class Telephone_example {
    public static void main(String[] args) {
        
        demoPhone tele = new demoPhone();
        tele.pickUp();
        tele.dial(1234567891);
        tele.recieve();
        tele.endCall();
    }
}