package com.yahoo.demonte.chris.schoolfinder;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
public class School implements Serializable{

    private static final long serialVersionUID = -4984735821343303953L;
    private int id;
    private String name;
    private String state;
    private String city;
    private String zip;
    private int state_fips;
    private int region_id;
    private int locale;
    private String lon;
    private String lat;
    private String accreditor;
    private String school_url;
    private int degrees_awarded;
    private int ownership;
    private int size;
    private double admission_rate;
    private double math_sat_25th;
    private double math_sat_75th;
    private double reading_sat_25th;
    private double reading_sat_75th;
    private int in_state_tuition;
    private int out_of_state_tuition;
    public School(){
    }

    public School(int id, String name, String state, String city, String zip, int state_fips, int region_id, int locale, String lon, String lat, String accreditor, String school_url, int degrees_awarded, int ownership, int size, double admission_rate, double math_sat_25th, double math_sat_75th, double reading_sat_25th, double reading_sat_75th, int in_state_tuition, int out_of_state_tuition) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.state_fips = state_fips;
        this.region_id = region_id;
        this.locale = locale;
        this.lon = lon;
        this.lat = lat;
        this.accreditor = accreditor;
        this.school_url = school_url;
        this.degrees_awarded = degrees_awarded;
        this.ownership = ownership;
        this.size = size;
        this.admission_rate = admission_rate;
        this.math_sat_25th = math_sat_25th;
        this.math_sat_75th = math_sat_75th;
        this.reading_sat_25th = reading_sat_25th;
        this.reading_sat_75th = reading_sat_75th;
        this.in_state_tuition = in_state_tuition;
        this.out_of_state_tuition = out_of_state_tuition;
    }

    public int getId() {
        return id;
    }

    @JsonSetter("id")
    public void setId(int id) {
        this.id = id;
    }
    /**
     public void setId(String id){
     if (id.contentEquals("null")){
     this.id = -1;
     }
     else {
     this.id = Integer.parseInt(id);
     }
     }
     */

    public String getName() {
        return name;
    }

    @JsonSetter("school.name")
    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    @JsonSetter("school.state")
    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    @JsonSetter ("school.zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getState_fips() {
        return state_fips;
    }

    @JsonSetter("school.state_fips")
    public void setState_fips(int state_fips) {
        this.state_fips = state_fips;
    }
    /**
     public void setState_fips(String state_fips){
     if (state_fips.contentEquals("null")){
     this.id = -1;
     }
     else {
     this.id = Integer.parseInt(state_fips);
     }
     }
     **/
    public int getRegion_id() {
        return region_id;
    }

    @JsonSetter("school.region_id")
    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
    /**
     public void setRegion_Id(String region_id){
     if (region_id.contentEquals("null")){
     this.id = -1;
     }
     else {
     this.id = Integer.parseInt(region_id);
     }
     }
     */
    public int getLocale() {
        return locale;
    }

    @JsonSetter("school.locale")
    public void setLocale(int locale) {
        this.locale = locale;
    }
    /**
     public void setLocale(String locale){
     if (locale.contentEquals("null")){
     this.id = -1;
     }
     else {
     this.id = Integer.parseInt(locale);
     }
     }
     */
    public String getLon() {
        return lon;
    }

    @JsonSetter("location.lon")
    public void setLon(String lon) {
        this.lon = lon;
    }
    /**
     public void setLon(String lon){
     if (lon.contentEquals("null")){
     this.lon = -1;
     }
     else {
     this.lon = Double.parseDouble(lon);
     }
     }
     */
    public String getLat() {
        return lat;
    }

    @JsonSetter("location.lat")
    public void setLat(String lat) {
        this.lat = lat;
    }
    /**
     public void setLat(String lat){
     if (lat.contentEquals("null")){
     this.lat = -1;
     }
     else {
     this.lon = Double.parseDouble(lat);
     }
     }
     */
    public String getAccreditor() {
        return accreditor;
    }

    @JsonSetter("school.accreditor")
    public void setAccreditor(String accreditor) {
        this.accreditor = accreditor;
    }

    public String getSchool_url() {
        return school_url;
    }
    @JsonSetter("school.school_url")
    public void setSchool_url(String school_url) {
        this.school_url = school_url;
    }

    public int getDegrees_awarded() {
        return degrees_awarded;
    }
    @JsonSetter("school.degrees_awarded.predominant")
    public void setDegrees_awarded(int degrees_awarded) {
        this.degrees_awarded = degrees_awarded;
    }
    /**
     public void setDegrees_awarded(String degree){
     if (degree.contentEquals("null")){
     this.degrees_awarded = -1;
     }
     else {
     this.degrees_awarded = Integer.parseInt(degree);
     }
     }
     */
    public int getOwnership() {
        return ownership;
    }

    @JsonSetter("school.ownership")
    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }
    /**
     public void setOwnership(String ownership){
     if (ownership.contentEquals("null")){
     this.ownership = -1;
     }
     else {
     this.ownership = Integer.parseInt(ownership);
     }
     }
     */
    public int getSize() {
        return size;
    }

    @JsonSetter("2013.student.size")
    public void setSize(int size) {
        this.size = size;
    }
    /**
     public void setSize(String size){
     if (size.contentEquals("null")){
     this.size = -1;
     }
     else {
     this.size = Integer.parseInt(size);
     }
     }
     */
    public double getAdmission_rate() {
        return admission_rate;
    }

    @JsonSetter("latest.admissions.admission_rate.overall")
    public void setAdmission_rate(double admission_rate) {
        this.admission_rate = admission_rate;
    }
    /**
     public void setAdmission_rate(String rate){
     if (rate.contentEquals("null")){
     this.admission_rate = -1;
     }
     else {
     this.admission_rate = Double.parseDouble(rate);
     }
     }
     */
    public double getMath_sat_25th() {
        return math_sat_25th;
    }

    @JsonSetter("latest.admissions.sat_scores.25th_percentile.math")
    public void setMath_sat_25th(double math_sat_25th) {
        this.math_sat_25th = math_sat_25th;
    }
    /**
     public void setMath_sat_25th(String score){
     if (score.contentEquals("null")){
     this.math_sat_25th = -1;
     }
     else {
     this.math_sat_25th = Double.parseDouble(score);
     }
     }
     */
    public double getMath_sat_75th() {
        return math_sat_75th;
    }
    @JsonSetter("latest.admissions.sat_scores.75th_percentile.math")
    public void setMath_sat_75th(double math_sat_75th) {
        this.math_sat_75th = math_sat_75th;
    }
    /**
     public void setMath_sat_75th(String score){
     if (score.contentEquals("null")){
     this.math_sat_75th = -1;
     }
     else {
     this.math_sat_75th = Double.parseDouble(score);
     }
     }
     */

    public double getReading_sat_25th() {
        return reading_sat_25th;
    }
    @JsonSetter("latest.admissions.sat_scores.25th_percentile.critical_reading")
    public void setReading_sat_25th(double reading_sat_25th) {
        this.reading_sat_25th = reading_sat_25th;
    }
    /**
     public void setReading_sat_25th(String score){
     if (score.contentEquals("null")){
     this.reading_sat_25th = -1;
     }
     else {
     this.reading_sat_25th = Double.parseDouble(score);
     }
     }
     **/
    public double getReading_sat_75th() {
        return reading_sat_75th;
    }

    @JsonSetter("latest.admissions.sat_scores.75th_percentile.critical_reading")
    public void setReading_sat_75th(double reading_sat_75th) {
        this.reading_sat_75th = reading_sat_75th;
    }
    /**
     public void setReading_sat_75th(String score){
     if (score.contentEquals("null")){
     this.reading_sat_75th = -1;
     }
     else {
     this.reading_sat_75th = Double.parseDouble(score);
     }
     }
     */

    public int getIn_state_tuition() {
        return in_state_tuition;
    }

    @JsonSetter("latest.cost.tuition.in_state")
    public void setIn_state_tuition(int in_state_tuition) {
        this.in_state_tuition = in_state_tuition;
    }
    /**
     public void setIn_state_tuition(String tuition){
     if (tuition.contentEquals("null")){
     this.in_state_tuition = -1;
     }
     else {
     this.in_state_tuition = Integer.parseInt(tuition);
     }
     }
     */
    public int getOut_of_state_tuition() {
        return out_of_state_tuition;
    }

    @JsonSetter("latest.cost.tuition.out_of_state")
    public void setOut_of_state_tuition(int out_of_state_tuition) {
        this.out_of_state_tuition = out_of_state_tuition;
    }
    /**
     public void setOut_of_state_tuition(String tuition){
     if (tuition.contentEquals("null")){
     this.out_of_state_tuition = -1;
     }
     else {
     this.out_of_state_tuition = Integer.parseInt(tuition);
     }
     }
     */

    public String getCity() {
        return city;
    }

    @JsonSetter("school.city")
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "School [\n id=" + id + "\n name=" + name + "\n state=" + state + "\n city=" + city + "\n zip=" + zip
                + "\n state_fips=" + state_fips + "\n region_id=" + region_id + "\n locale=" + locale + "\n lon=" + lon
                + "\n lat=" + lat + "\n accreditor=" + accreditor + "\n school_url=" + school_url + "\n degrees_awarded="
                + degrees_awarded + "\n ownership=" + ownership + "\n size=" + size + "\n admission_rate=" + admission_rate
                + "\n math_sat_25th=" + math_sat_25th + "\n math_sat_75th=" + math_sat_75th + "\n reading_sat_25th="
                + reading_sat_25th + "\n reading_sat_75th=" + reading_sat_75th + "\n in_state_tuition=" + in_state_tuition
                + "\n out_of_state_tuition=" + out_of_state_tuition + "\n]";
    }
    public String toFancyString(){
        return "City: " + city + "\nState: " + States.getStatefromFIPSCode(state_fips) + " (" + state + ")\nZipcode: "+ zip
                + "\nRegion: " + States.getRegion(region_id) + "\nLocale: " + States.getLocale(locale) + "\nLongitude: " + lon
                + "\nLatitude: " + lat + "\nSchool URL: " + school_url + "\nAccreditor: " + accreditor +  "\nPrimary Degree Awareded: "
                + States.getDegreeAwareded(degrees_awarded) + "\nOwnership: " + States.getOwnership(ownership) + "\nSchool Size: " + negOneFilter(""+size) + "\n Admission Rate: " + negOneFilter(""+admission_rate)
                + "\n25th Percentile Math SAT Score: " + negOneFilter(""+math_sat_25th) + "\n75th Percentile Math SAT Score: " + negOneFilter(""+math_sat_75th) + "\n25th Percentile Reading SAT Score: "
                + negOneFilter(""+ reading_sat_25th) + "\n75th Percentile Reading SAT Score: " + negOneFilter(""+reading_sat_75th) + "\nIn State Tuition: " + negOneFilter(""+in_state_tuition)
                + "\nOut of State Tuition: " + negOneFilter(""+out_of_state_tuition) + "\n";
    }
    public String negOneFilter(String str){
        if (str.contentEquals("-1")){
            return "No data.";
        }
        else {
            return str;
        }
    }
}

