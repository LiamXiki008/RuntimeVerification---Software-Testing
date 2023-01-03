package main;

public class Runner_2 {

    //Invalid login
    public void invalidCredentials(){
        System.out.println("Invalid credentials, not logged in.");
    }

    //Valid login
    public void validCredentials(){
        System.out.println("Valid credentials, logged in.");
    }

    //Log Out
    public void logOut(){
        System.out.println("Logged out.");
    }

    //View alerts attempt
    public void viewAlertsAttempt(Login login){
        if(login.getLoginStatus()){
            System.out.println("Viewing alerts.");
            viewAlerts();
        } else {
            System.out.println("Not logged in, cannot view alerts.");
        }
    }

    public void viewAlerts(){
        System.out.println("Alerts viewed.");
    }

    public void run(final Login login){

        while(true) {
            //randomly generate a number between 1 and 3
            int random = (int) (Math.random() * 3) + 1;

            switch (random) {
                case 1 : {
                    this.invalidCredentials();
                    login.loginStatus(false);
                    break;
                }

                case 2 : {
                    this.validCredentials();
                    login.loginStatus(true);

                    //randomly generate a number between 1 and 2
                    int random2 = (int) (Math.random() * 2) + 1;
                    switch (random2) {
                        case 1:
                            this.viewAlertsAttempt(login);
                            break;

                        case 2: {
                            this.logOut();
                            login.loginStatus(false);
                            break;
                        }
                    }
                }
                case 3:{
                	if(login.getLoginStatus()){
                    this.logOut();
                	}
                    login.loginStatus(false);
                    break;
                }
                default:
                    this.viewAlertsAttempt(login);
                    break;
            }

            //Sleep for 1 second
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Runner_2 runner = new Runner_2();
        Login login = new Login(false, false);
        runner.run(login);
    }

}