import hearingAid.HearingAid;
import hearingAid.HearingAidRegister;
import hearingAid.InputHandler;

public class HearingAidApp {

    HearingAidRegister hearingAidRegister;
    InputHandler inputHandler;
    int menuChoice;

    public static void main(String[] args) {
        HearingAidApp app = new HearingAidApp();
    }

    public HearingAidApp() {
        hearingAidRegister = new HearingAidRegister();
        inputHandler = new InputHandler();
        hearingAidRegister.fillHearingAidMap();
        start();
    }


    private final int REGISTER_NEW_HEARINGAID = 1;
    private final int SEE_ALL_INFORMATION = 2;
    private final int LOAN_HEARINGAID = 3;
    private final int RETURN_HEARINGAID = 4;
    private final int EXIT_APP = 5;

    public void init() {
        System.out.println("\n***** Hearing Aid Central v0.1 *****\n");
        System.out.println("1. Add hearing aid");
        System.out.println("2. See all Hearing aid information");
        System.out.println("3. Borrow a hearing aid");
        System.out.println("4. Return a hearing aid");
        System.out.println("5. Exit app");
        System.out.println("\nPlease select from the menu.\n");
    }

    public void start() {
        boolean finished = false;
        while(!finished) {
            init();
            menuChoice = inputHandler.getIntFromUser(1, 5);
            switch (menuChoice) {
                case REGISTER_NEW_HEARINGAID:
                    registerNewHearingAid();
                    System.out.println("1");
                    break;
                case SEE_ALL_INFORMATION:
                    seeAllInfo();
                    System.out.println("2");
                    break;
                case LOAN_HEARINGAID:
                    loanHearingAid();
                    System.out.println("3");
                    break;
                case RETURN_HEARINGAID:
                    returnHearingAid();
                    System.out.println("4");
                    break;
                case EXIT_APP:
                    System.out.println("Thank you for using our app!");
                    finished = true;
                    break;
                default:
                    System.out.println("Please enter a valid menuchoice");
            }


        }
    }

    public void registerNewHearingAid() {
        System.out.println("Please input the ID of the new hearing aid:");
        String idFromUser = inputHandler.getIdStringFromUser();
        System.out.println("Please input the hearing aid type:");
        String typeFromUser = inputHandler.getStringFromUser();
        if(hearingAidRegister.getHearingAidMap().containsKey(idFromUser)) {
            System.err.println("The id already exists in the register!");
        } else {
            hearingAidRegister.getHearingAidMap().put(idFromUser, new HearingAid(idFromUser, typeFromUser));
            System.out.println("Hearing aid successfully registered!");
        }
    }

    public void seeAllInfo() {
        System.out.println("\n NTNU-sentralen \n");
        System.out.println("Registrerte hjelpemidler: ");
        for(HearingAid hearingAidTemp:hearingAidRegister.getInformation()){
            System.out.println(hearingAidTemp.toString());
        }

    }

    public void loanHearingAid() {
        System.out.println("Please input the ID of the hearing aid you would like to borrow:");
        String idFromUser = inputHandler.getIdStringFromUser();
        System.out.println("Please input the name of the borrower:");
        String nameOfBorrowerFromUser = inputHandler.getStringFromUser();

        if(hearingAidRegister.getHearingAidMap().containsKey(idFromUser) && !hearingAidRegister.getHearingAidMap().get(idFromUser).isRentalStatus()) {
            System.out.println("Hearing aid " + idFromUser + " borrowed");
            hearingAidRegister.rentHearingAid(idFromUser, nameOfBorrowerFromUser);
        } else {
            System.err.println("The id was not found in the register or the hearing aid is already borrowed. Returning to menu.");
        }
    }

    public void returnHearingAid() {
        System.out.println("Please enter the id of the hearing aid you would like to deliver:");
        String idFromUser = inputHandler.getIdStringFromUser();

        if(hearingAidRegister.getHearingAidMap().containsKey(idFromUser) && hearingAidRegister.getHearingAidMap().get(idFromUser).isRentalStatus()){
            System.out.println("Hearing aid " + idFromUser + " delivered");
            hearingAidRegister.endRentalPeriod(idFromUser);
        } else{
            System.err.println("The id was not found in the register or the hearing aid is not borrowed. Returning to menu.");
        }

    }
}
