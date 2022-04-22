import java.time.LocalDate;

public class Project {

    private static int projectCounter = 1000;

    private boolean isActive;

    private Date projectStartDate;
    private Date estimatedEndDate;
    private Date actualEndDate;

    private String projectId;
    private String projectName;
    private String projectType;
    private String projectDescription;

    private String forStartDate;
    private String forEndDate;

    public Project(String name, String description, String startDate, String endDate) {
        projectName = name;
        projectDescription = description;
        setProjectStartDate(startDate);
        setProjectEndDate(endDate);
    }

    public void setProjectStartDate(String a) {
        Date compare = new Date("2000-1-1");
        Date today = new Date(2022, 4, 19);

        Date to = new Date(a);

        if (a.compareTo(compare.getDate()) > 0) {
            this.projectStartDate = today;
        }
        else {
            this.projectStartDate = to;
        }
    }

    public void setProjectEndDate(String b) {

        Date b1 = new Date(b);
        Date rand = new Date(this.projectStartDate);

        if ((b1.getDate()).compareTo(this.projectStartDate.getDate()) < 0) {
            b1 = rand.addDays(30);
        }

        estimatedEndDate = b1;
    }

    public void setActualEndDate() {

        if (!this.estimatedEndDate.isBefore(this.projectStartDate)) {
            this.actualEndDate = this.estimatedEndDate;
        } else {
            this.actualEndDate = null;
        }
    }

    public void setProjectType() {

        Date est = new Date(this.estimatedEndDate);
        Date start = new Date(this.projectStartDate);

        int leap = est.countLeapYears(start);
        int days = est.daysBetween(start);

        if (leap > 0) {

            if (days <= 365 + leap) {
                this.projectType = "SHORT TERM";
            }
            if (days > 365 + leap && days <= 1095 + leap) {

                this.projectType = "INTERMEDIATE";
            }
            if (days > 1095 + leap) {

                this.projectType = "LONG TERM";
            }

        } else {

            if (days <= 365) {
                this.projectType = "SHORT TERM";

            }
            if (days > 365 && days <= 1095) {
                this.projectType = "INTERMEDIATE";
            }
            if (days > 1095) {
                this.projectType = "LONG TERM";
            }
        }
    }

    public void setID(String Id) {

        if (projectType.equals("SHORT TERM")) {
            Id = "ST-1000";
        }
        if (projectType.equals("INTERMEDIATE")) {
            Id = "IM-1000";
        }
        if (projectType.equals("LONG TERM")) {
            Id = "LT-1000";
        }

        projectId = Id;
    }

    public void deActivateProject() {
        isActive = false;
        actualEndDate = estimatedEndDate;
    }

    public void activateProject() {
        isActive = true;
        actualEndDate = null;
    }

    public void pushProject(int days) {

        this.getEstimatedEndDate().addDays(days);
        setProjectType();
    }

    public int estimatedDaysToCompletion() {
        Date est = new Date(this.estimatedEndDate);
        Date start = new Date(this.projectStartDate);

        return est.daysBetween(start);
    }

    public boolean equals(Project rand) {
        if (this.projectName.equals(rand.projectName)) {
            return true;
        }
        return false;
    }

    public String toString() {

        Date today1 = new Date(2022, 4, 19);

        return ("Estimated days to completion: " + estimatedDaysToCompletion() + "\n \n"
                + today1.daysBetween(this.getEstimatedEndDate()) + " days late \n" +
                "ID: (" + projectId + ") \n" + "Project name: " + projectName + "\n Project Description: "
                + projectDescription + "\n Start: " +
                projectStartDate.toString() + " End: " + today1.toString());
    }

    
    public int getCount() {
        return projectCounter;
    }

    public boolean getActiveness() {
        return isActive;
    }

    public Date getStartDate() {
        return projectStartDate;
    }

    public Date getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public Date getActualEnd() {
        return actualEndDate;
    }

    public String getDescription() {
        return projectDescription;
    }

    public String getId() {
        return projectId;
    }

    public String getName() {
        return projectName;
    }

    public String getType() {
        return projectType;
    }

}
