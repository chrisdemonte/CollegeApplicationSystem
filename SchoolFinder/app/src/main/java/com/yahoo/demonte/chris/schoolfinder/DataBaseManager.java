package com.yahoo.demonte.chris.schoolfinder;

import android.content.Context;
import com.google.firebase.storage.StorageReference;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class DataBaseManager {

    public static TreeMap<String, School> schoolList = new TreeMap<String, School>();
    private static StorageReference mStorageRef;
    public static int pageCount = 0;
    public static DatabaseHelper dbHelper;
    /*
    public static final String apiQuery = "https://api.data.gov/ed/collegescorecard/v1/schools.json?&fields=id,school.name,school.city,school.state,school.zip,school.state_fips,school.region_id,school.locale,location.lat,location.lon,school.accreditor,school.school_url,school.degrees_awarded.predominant,school.ownership,2013.student.size,latest.admissions.admission_rate.overall,latest.admissions.sat_scores.25th_percentile.critical_reading,latest.admissions.sat_scores.75th_percentile.critical_reading,latest.admissions.sat_scores.25th_percentile.math,latest.admissions.sat_scores.75th_percentile.math,latest.cost.tuition.in_state,latest.cost.tuition.out_of_state&api_key=WEvhaC3y3VcHP7NEHbCuWUqpdgFEfTvfMC4okk4C";
    public static int pageCount = 0;
    &_per_page=100&page=0&sort=school.name;
    */


    public static void updateDatabase(Context c){
        /*

        mStorageRef = FirebaseStorage.getInstance().getReference();
        File localFile = File.createTempFile("college_list", "txt");
        mStorageRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });
         */
        dbHelper = new DatabaseHelper(c);
        BufferedReader br = null;
        try {
            File file = new File(c.getFilesDir(), "college_data.txt");
            if (file.exists()){
                br = new BufferedReader(new FileReader(file));
                String id;
                while ((id = br.readLine()) != null){

                    String name = br.readLine();
                    String state= br.readLine();
                    String city= br.readLine();
                    String zip= br.readLine();
                    int state_fips= Integer.parseInt(br.readLine());
                    int region_id= Integer.parseInt(br.readLine());
                    int locale= Integer.parseInt(br.readLine());
                    String lon= br.readLine();
                    String lat= br.readLine();
                    String accreditor= br.readLine();
                    String school_url= br.readLine();
                    int degrees_awarded= Integer.parseInt(br.readLine());
                    int ownership= Integer.parseInt(br.readLine());
                    int size= Integer.parseInt(br.readLine());
                    double admission_rate= Double.parseDouble(br.readLine());
                    double math_sat_25th= Double.parseDouble(br.readLine());
                    double math_sat_75th= Double.parseDouble(br.readLine());
                    double reading_sat_25th= Double.parseDouble(br.readLine());
                    double reading_sat_75th= Double.parseDouble(br.readLine());
                    int in_state_tuition= Integer.parseInt(br.readLine());
                    int out_of_state_tuition= Integer.parseInt(br.readLine());

                    School school = new School(Integer.parseInt(id), name, state, city, zip, state_fips, region_id, locale, lon, lat, accreditor, school_url, degrees_awarded,
                    ownership, size, admission_rate, math_sat_25th, math_sat_75th, reading_sat_25th, reading_sat_75th, in_state_tuition, out_of_state_tuition);

                    schoolList.put(""+id, school);
                    //dbHelper.insertSchool(school);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //DatabaseHelper dbHelper = new DatabaseHelper(c);
        //System.out.println(schoolList.size());
        /*
        for (int i = 0; i < schoolList.size(); i++){
            dbHelper.insertSchool(schoolList.get(i));
        }
*/
        /**
        pageCount = 0;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String inline = "";
                try {
                    URL url = new URL("https://api.data.gov/ed/collegescorecard/v1/schools.json?&fields=id,school.name,school.city,school.state,school.zip,school.state_fips,school.region_id,school.locale,location.lat,location.lon,school.accreditor,school.school_url,school.degrees_awarded.predominant,school.ownership,2013.student.size,latest.admissions.admission_rate.overall,latest.admissions.sat_scores.25th_percentile.critical_reading,latest.admissions.sat_scores.75th_percentile.critical_reading,latest.admissions.sat_scores.25th_percentile.math,latest.admissions.sat_scores.75th_percentile.math,latest.cost.tuition.in_state,latest.cost.tuition.out_of_state&api_key=WEvhaC3y3VcHP7NEHbCuWUqpdgFEfTvfMC4okk4C&_per_page=100&page="+ pageCount + "&sort=school.name");
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();

                    int responseCode = conn.getResponseCode();
                    if(responseCode != 200) {
                        throw new RuntimeException("HttpResponseCode: " + responseCode);
                    } else {
                        Scanner sc = new Scanner(url.openStream());
                        while(sc.hasNext()) {
                            inline += sc.next();
                        }
                        inline = inline.substring(inline.indexOf("["), inline.lastIndexOf("}")).replaceAll("null", "-1");
                        System.out.println(inline);
                        sc.close();
                        ObjectMapper mapper = new ObjectMapper();
                        School[] schools = mapper.readValue(inline, School[].class);
                        for (int i = 0; i < schools.length;i++){
                            schoolList.add(schools[i]);
                        }


                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();
         */

/**
        while (pageCount < 72){
            //APIQueryTask task = new APIQueryTask();
            String json = getTestString();

           // String[] array = json.substring(json.indexOf("[") + 2,json.lastIndexOf("]")).split("},");
         //   for (int i = 0; i < array.length;i++){
                School school = new School(json.substring(json.indexOf("[") + 2,json.lastIndexOf("]")));
                schoolList.add(school);
        //    }
            pageCount++;
        }
        if (true) {
            saveDatabase(c, schoolList);
 }
 */


    }
    public static String getTestString(){
        return "[{\"school.region_id\":4,\"location.lon\":-92.589183,\"school.name\":\"A T Still University of Health Sciences\",\"school.accreditor\":\"Higher Learning Commission\",\"school.state_fips\":29,\"school.city\":\"Kirksville\",\"school.ownership\":2,\"school.zip\":\"63501\",\"location.lat\":40.193648,\"school.school_url\":\"WWW.ATSU.EDU\",\"school.degrees_awarded.predominant\":4,\"school.state\":\"MO\",\"id\":177834,\"school.locale\":33,\"2013.student.size\":null,\"latest.admissions.admission_rate.overall\":null,\"latest.admissions.sat_scores.25th_percentile.critical_reading\":null,\"latest.admissions.sat_scores.75th_percentile.critical_reading\":null,\"latest.admissions.sat_scores.25th_percentile.math\":null,\"latest.admissions.sat_scores.75th_percentile.math\":null,\"latest.cost.tuition.in_state\":null,\"latest.cost.tuition.out_of_state\":null}";
    }
    public static void saveDatabase(Context c, ArrayList<School> schoolList){
        File file = new File(c.getFilesDir(), "school_database.data");
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(schoolList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
