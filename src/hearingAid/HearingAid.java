package hearingAid;

import java.util.Objects;

/**
 * Class that represents the hearingAid.HearingAid class.
 * @author 10000
 * @version 1.0.0
 */
public class HearingAid {

    private String id;
    private String type;
    private boolean rentalStatus;
    private String nameOfBorrower;

    /**
     * Constructor for the hearingAid.HearingAid class that takes inn all parameters:
     * @param id
     * @param type
     * @param rentalStatus
     * @param nameOfBorrower
     */
    public HearingAid(String id, String type, boolean rentalStatus, String nameOfBorrower){
        this.id = id;
        this.type = type;
        this.rentalStatus = rentalStatus;
        this.nameOfBorrower = nameOfBorrower;
    }

    public HearingAid(String id, String type){
        this.id = id;
        this.type = type;
        this.rentalStatus = false;
        this.nameOfBorrower = "";
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    /**
     * getter for the rentalStatus field.
     * @return true/false based on if the hearing aid is rented or not.
     */
    public boolean isRentalStatus() {
        return rentalStatus;
    }

    public String getNameOfBorrower() {
        return nameOfBorrower;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public void setNameOfBorrower(String nameOfBorrower) {
        this.nameOfBorrower = nameOfBorrower;
    }

    /**
     * A method that creates a String from an objects field values.
     * @return String of information about an object.
     */
    @Override
    public String toString() {
        if(isRentalStatus()) {
            return getId() + " " + getType() + " utleid til " + getNameOfBorrower();
        }else{
            return getId() + " " + getType() + " ledig";
        }
    }

    /**
     * A method that checks if the objects field value is equal to that of another, taken in by parameter:
     * @param o
     * @return true/false based on if the values are equal or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HearingAid that = (HearingAid) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(nameOfBorrower, that.nameOfBorrower);
    }

    /**
     * A method that creates a hashCode for an objects field values.
     * @return a hash of an objects field values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, type, nameOfBorrower);
    }
}
