package pervasivecomputing.example.meditrack;

public class Medications {
    private String medicationsName, recognizedText;

    public Medications(){
    }

    public String getMedicationsName(){
        return medicationsName;
    }
    public void setMedicationsName(String medicationsName){
        this.medicationsName = medicationsName;
    }
    public String getRecognizedText(){
        return recognizedText;
    }
    public void setRecognizedText(String recognizedText){
        this.recognizedText = recognizedText;
    }
}
