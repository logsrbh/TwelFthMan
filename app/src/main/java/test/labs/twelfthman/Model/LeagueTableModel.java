package test.labs.twelfthman.Model;

public class LeagueTableModel {

    String teamName;
    String teamno;
    String pts;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    String group;
    public String getTeamno() {
        return teamno;
    }


    public LeagueTableModel()
    {

    }


    public void setTeamno(String teamno) {
        this.teamno = teamno;
    }

    String imageurl;
    String pj;
    String gf;
    String ga;
    String diff;


    public LeagueTableModel(String group,String teamno,String teamName, String imageurl, String pj, String gf, String ga, String diff, String pts) {
        this.teamName = teamName;
        this.imageurl = imageurl;
        this.pj = pj;
        this.gf = gf;
        this.ga = ga;
        this.diff = diff;
        this.pts = pts;
        this.teamno=teamno;
        this.group=group;

    }

    public void setTeamName(String teamName) {

        this.teamName = teamName;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }

    public String getTeamName() {

        return teamName;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getPj() {
        return pj;
    }

    public String getGf() {
        return gf;
    }

    public String getGa() {
        return ga;
    }

    public String getDiff() {
        return diff;
    }

    public String getPts() {
        return pts;
    }



}
