/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jacobmarsnik.geotest;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Constants used in this sample.
 */

final class Constants {

    private Constants() {}

    public static final String DB_URL = "https://spewyr.000webhostapp.com/connect/";
    
    public static final String REGISTER_URL = DB_URL + "register.php";
    public static final String LOGIN_URL =  DB_URL + "login.php";
    
    public static final String KEY_FIRST_NAME = "first name";
    public static final String KEY_LAST_NAME = "last name";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";


    private static final String PACKAGE_NAME = "com.google.android.gms.location.Geofence";

    static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";


    static  final int GEOFENCE_RADIUS_IN_METERS = 75;

    /**
     * Used to set an expiration time for a geofence. After this amount of time Location Services
     * stops tracking the geofence.
     */
    private static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;


    /**
     * Map for storing information about airports in the San Francisco bay area.
     */
    static final HashMap<String, LatLng> S = new HashMap<>();

    static {
        // San Francisco International Airport.
        S.put("SFO", new LatLng(44.848931, -92.624509));

        // Googleplex.
        S.put("GOOGLE", new LatLng(37.422611,-122.0840577));

        S.put("Library", new LatLng(44.852954, -92.623018));

        S.put("Home", new LatLng(44.849036, -92.624522));

        S.put("cassie's house", new LatLng(44.845154, -92.631958));

        S.put("Ames", new LatLng(44.8516291,-92.6148443 ));

        S.put("South Hall", new LatLng(44.853484, -92.6233754));

        S.put("Apt8", new LatLng(44.8516042, -92.6099064));

    }
}
