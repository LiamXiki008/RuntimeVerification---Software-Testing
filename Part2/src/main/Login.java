package main;

public class Login {
    private boolean loggedIn = false;
    private boolean alertsViewed = false;

    public Login(final boolean loggedIn, final boolean alertsViewed) {
        this.loggedIn = loggedIn;
        this.alertsViewed = alertsViewed;
    }

    public void loginStatus(final boolean loggedInStatus) {
        this.loggedIn = loggedInStatus;
       }
    public void viewAlertsStatus(final boolean alertsViewedStatus) {
        this.alertsViewed = alertsViewedStatus;
       }

       public boolean getLoginStatus() {
        return this.loggedIn;
       }
         public boolean getViewAlertsStatus() {
          return this.alertsViewed;
         }

}
