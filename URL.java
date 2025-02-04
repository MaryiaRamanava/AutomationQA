package constants;

public enum URL {
    AUTO_PRACTICE("http://www.automationpractice.pl/index.php"), ZOO("https://zoo.waw.pl/"), W3SCHOOL("https://www.w3schools.com/"), CLICK_SPEED_TESTER("https://www.clickspeedtester.com/click-counter/"), ANDERSENLAB("https://andersenlab.com/"), QACOURSE("https://qa-course-01.andersenlab.com/");

    private String url;
    public String getUrl(){
        return url;
    }
    URL(String url){
        this.url = url;
    }
}
