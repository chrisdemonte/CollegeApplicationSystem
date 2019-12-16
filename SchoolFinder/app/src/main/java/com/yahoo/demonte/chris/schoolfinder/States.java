package com.yahoo.demonte.chris.schoolfinder;

public enum States {
    ALABAMA, ALASKA, ARIZONA, ARKANSAS, CALIFORNIA, COLORADO, CONNECTICUT, DELAWARE,
    DISTRICT_OF_COLUMBIA, FLORIDA, GEORGIA, HAWAII, IDAHO, ILLINOIS, INDIANA, IOWA, KANSAS, KENTUCKY, LOUISIANA,
    MAINE, MARYLAND, MASSACHUESETTS, MICHIGAN, MINNESOTA, MISSISSSIPPI, MISSOURI, MONTANA,
    NEBRASKA, NEVADA, NEW_HAMPSHIRE, NEW_JERSEY, NEW_MEXICO, NEW_YORK, NORTH_CAROLINA, NORTH_DAKOTA,
    OHIO, OKLAHOMA, OREGON, PENNSYLVANIA, RHODE_ISLAND, SOUTH_CAROLINA, SOUTH_DAKOTA, TENNESSEE,
    TEXAS, UTAH, VERMONT, VIRGINIA, WASHINGTON, WEST_VIRGINIA, WISCONSIN, WYOMING, AMERICAN_SAMOA, FEDERATED_STATES_OF_MICRONESIA,
    GUAM, NORTHERN_MARIANA_ISLANDS, PALAU, PUERTO_RICO, VIRGIN_ISLANDS;


   public static String getStatefromFIPSCode(int state_fips){

       switch (state_fips){
           case 1:
               return "ALABAMA";
           case 2:
               return "ALASKA";
           case 4:
               return "ARIZONA";
           case 5:
               return "ARKANSAS";
           case 6:
               return "CALIFORNIA";
           case 8:
               return "COLORADO";
           case 9:
               return "CONNECTICUT";
           case 10:
               return "DELAWARE";
           case 11:
               return "DISTRICT OF COLUMBIA";
           case 12:
               return "FLORIDA";
           case 13:
               return "GEORGIA";
           case 15:
               return "HAWAII";
           case 16:
               return "IDAHO";
           case 17:
               return "ILLINOIS";
           case 18:
               return "INDIANA";
           case 19:
               return "IOWA";
           case 20:
               return "KANSAS";
           case 21:
               return "KENTUCKY";
           case 22:
               return "LOUISIANA";
           case 23:
               return "MAINE";
           case 24:
               return "MARYLAND";
           case 25:
               return "MASSACHUESETTS";
           case 26:
               return "MICHIGAN";
           case 27:
               return "MINNESOTA";
           case 28:
               return "MISSISSSIPPI";
           case 29:
               return "MISSOURI";
           case 30:
               return "MONTANA";
           case 31:
               return "NEBRASKA";
           case 32:
               return "NEVADA";
           case 33:
               return "NEW HAMPSHIRE";
           case 34:
               return "NEW JERSEY";
           case 35:
               return "NEW MEXICO";
           case 36:
               return "NEW YORK";
           case 37:
               return "NORTH CAROLINA";
           case 38:
               return "NORTH DAKOTA";
           case 39:
               return "OHIO";
           case 40:
               return "OKLAHOMA";
           case 41:
               return "OREGON";
           case 42:
               return "PENNSYLVANIA";
           case 44:
               return "RHODE ISLAND";
           case 45:
               return "SOUTH CAROLINA";
           case 46:
               return "SOUTH DAKOTA";
           case 47:
               return "TENNESSEE";
           case 48:
               return "TEXAS";
           case 49:
               return "UTAH";
           case 50:
               return "VERMONT";
           case 51:
               return "VIRGINIA";
           case 53:
               return "WASHINGTON";
           case 54:
               return "WEST VIRGINIA";
           case 55:
               return "WISCONSIN";
           case 56:
               return "WYOMING";
           case 60:
               return "AMERICAN SAMOA";
           case 64:
               return "FEDERATED STATES OF MICRONESIA";
           case 66:
               return "GUAM";
           case 69:
               return "NORTHERN MARIANA ISLANDS";
           case 70:
               return "PALAU";
           case 72:
               return "PUERTO RICO";
           case 78:
               return "VIRGIN ISLANDS";
           default:
               return "";
       }
   }
    public static String getLocale (int locale){
       switch(locale) {
           case 11 :
               return "City: Large with a population of 250,000 or more.";
           case 12 :
               return "City: Midsize with a population of at least 100,000 but less than 250,000.";
           case 13 :
               return "City: Small with a population less than 100,000.";
           case 21 :
               return "Suburb: Large. Outside principal city, in urbanized area with population of 250, 000or more.";
           case 22 :
               return "Suburb: Midsize. Outside principal city, in urbanized area with population of at least 100,000 but less than 250,000.";
           case 23 :
               return "Suburb: Small. Outside principal city, in urbanized area with population less than 100,000.";
           case 31 :
               return "Town: Fringe. In urban cluster up to 10 miles from an urbanized area.";
           case 32 :
               return "Town: Distant urban cluster more than 10 miles and up to 35 miles from an urbanized area.";
           case 33 :
               return "Town: Remote urban cluster more than 35miles from an urbanized area.";
           case 41 :
               return "Rural: Fringe territory up to 5miles from an urbanized area or up to 2.5 miles from an urban cluster.";
           case 42 :
               return "Rural: Distant rural territory more than 5 miles but up to 25 miles from an urbanized area or more than 2.5 and up to 10 miles from an urban cluster.";
           case 43 :
               return "Rural: Remote rural territory more than 25 miles from an urbanized area and more than 10 miles from an urban cluster.";
           default:
               return "No data on locale.";
       }

    }
    public static String getRegion (int region){
       switch (region) {
           case 0 :
               return "U.S.Service Schools";
           case 1 :
               return "New England (CT, ME, MA, NH, RI, VT)";
           case 2 :
               return "Mid East (DE, DC, MD, NJ, NY, PA)";
           case 3 :
               return "Great Lakes (IL, IN, MI, OH, WI)";
           case 4 :
               return "Plains(IA, KS, MN, MO, NE, ND, SD)";
           case 5 :
               return "Southeast(AL, AR, FL, GA, KY, LA, MS, NC, SC, TN, VA, WV)";
           case 6 :
               return "Southwest(AZ, NM, OK, TX)";
           case 7 :
               return "Rocky Mountains (CO, ID, MT, UT, WY)";
           case 8 :
               return "Far West (AK, CA, HI, NV, OR, WA)";
           case 9 :
               return "Outlying Areas (AS, FM, GU, MH, MP, PR, PW, VI)";
           default:
               return "No data on region.";

       }

    }
    public static String getOwnership (int ownership){
       switch (ownership) {
           case 1:
               return "Public";
           case 2 :
               return "Private Nonprofit";
           case 3 :
               return "Private for -profit";
           default:
               return "No data on ownership";
       }

    }
    public static String getDegreeAwareded(int degree){
       switch (degree) {
           case 1:
               return "Predominantly Certificate-Degree Granting";
           case 2:
               return "Predominantly Associate's-Degree Granting";
           case 3:
               return "Predominantly Bachelor's-Degree Granting";
           case 4:
               return "Entirely Graduate-Degree Granting";
           default:
               return "Not classified";
       }

    }
    public static String getStateName(States state){

        switch (state){
            case ALABAMA:
                return "ALABAMA";
            case ALASKA:
                return "ALASKA";
            case ARIZONA:
                return "ARIZONA";
            case ARKANSAS:
                return "ARKANSAS";
            case CALIFORNIA:
                return "CALIFORNIA";
            case COLORADO:
                return "COLORADO";
            case CONNECTICUT:
                return "CONNECTICUT";
            case DELAWARE:
                return "DELAWARE";
            case DISTRICT_OF_COLUMBIA:
                return "DISTRICT OF COLUMBIA";
            case FLORIDA:
                return "FLORIDA";
            case GEORGIA:
                return "GEORGIA";
            case HAWAII:
                return "HAWAII";
            case IDAHO:
                return "IDAHO";
            case ILLINOIS:
                return "ILLINOIS";
            case INDIANA:
                return "INDIANA";
            case IOWA:
                return "IOWA";
            case KANSAS:
                return "KANSAS";
            case KENTUCKY:
                return "KENTUCKY";
            case LOUISIANA:
                return "LOUISIANA";
            case MAINE:
                return "MAINE";
            case MARYLAND:
                return "MARYLAND";
            case MASSACHUESETTS:
                return "MASSACHUESETTS";
            case MICHIGAN:
                return "MICHIGAN";
            case MINNESOTA:
                return "MINNESOTA";
            case MISSISSSIPPI:
                return "MISSISSSIPPI";
            case MISSOURI:
                return "MISSOURI";
            case MONTANA:
                return "MONTANA";
            case NEBRASKA:
                return "NEBRASKA";
            case NEVADA:
                return "NEVADA";
            case NEW_HAMPSHIRE:
                return "NEW HAMPSHIRE";
            case NEW_JERSEY:
                return "NEW JERSEY";
            case NEW_MEXICO:
                return "NEW MEXICO";
            case NEW_YORK:
                return "NEW YORK";
            case NORTH_CAROLINA:
                return "NORTH CAROLINA";
            case NORTH_DAKOTA:
                return "NORTH DAKOTA";
            case OHIO:
                return "OHIO";
            case OKLAHOMA:
                return "OKLAHOMA";
            case OREGON:
                return "OREGON";
            case PENNSYLVANIA:
                return "PENNSYLVANIA";
            case RHODE_ISLAND:
                return "RHODE ISLAND";
            case SOUTH_CAROLINA:
                return "SOUTH CAROLINA";
            case SOUTH_DAKOTA:
                return "SOUTH DAKOTA";
            case TENNESSEE:
                return "TENNESSEE";
            case TEXAS:
                return "TEXAS";
            case UTAH:
                return "UTAH";
            case VERMONT:
                return "VERMONT";
            case VIRGINIA:
                return "VIRGINIA";
            case WASHINGTON:
                return "WASHINGTON";
            case WEST_VIRGINIA:
                return "WEST VIRGINIA";
            case WISCONSIN:
                return "WISCONSIN";
            case WYOMING:
                return "WYOMING";
            case AMERICAN_SAMOA:
                return "AMERICAN SAMOA";
            case FEDERATED_STATES_OF_MICRONESIA:
                return "FEDERATED STATES OF MICRONESIA";
            case GUAM:
                return "GUAM";
            case NORTHERN_MARIANA_ISLANDS:
                return "NORTHERN MARIANA ISLANDS";
            case PALAU:
                return "PALAU";
            case PUERTO_RICO:
                return "PUERTO RICO";
            case VIRGIN_ISLANDS:
                return "VIRGIN ISLANDS";
            default:
                return "NOTHING";
        }
    }




}
