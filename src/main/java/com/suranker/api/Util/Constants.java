package com.suranker.api.Util;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Constants {

    //Request param related
    public static final String pageNumberParameter = "pageNo";
    public static final String stateParameter = "state";
    public static final String maximumMedianPriceParameter = "mmp";
    public static final String propertyTypeParameter = "type";
    public static final String propertyTypeHouse = "house";
    public static final String sortParameter = "sortBy";
    public static final String defaultStateSelection = "All";
    public static final String defaultPageNo = "1";
    public static final Set<String> allowedStateValues = new HashSet<>(
            Arrays.asList("All", "NSW", "VIC", "QLD", "SA", "WA", "TAS", "NT"));
    public static final Set<String> allowedTypeValues = new HashSet<>(
            Arrays.asList("unit", "house"));
    public static final String defaultSortOrder = "rel";
    public static final Set<String> allowedSortValues = new HashSet<>(
            Arrays.asList("rel", "dem"));


    //Entity related
    public static final String hospitalEntityName = "hospitals";
    public static final String hospitalIdColumn = "hospital_id";
    public static final String wikiSumaaryEntityName = "wikipedia_desc";
    public static final String suburbIdColumn = "suburb_id";
    public static final String lgaEntityName = "lgas";
    public static final String lgaIdColumn = "lga_id";
    public static final String universitiesEntityName = "universities";
    public static final String universityIdColumn = "university_id";
    public static final String suburbsEntityName = "suburbs";
    public static final String lgaNameColumnName = "lga_name";
    public static final String populationGrowthColumnName = "population_growth";
    public static final String uniNameColumn = "university_name";
    public static final String suburbNameColumn = "suburb_name";
    public static final String hospitalNameColumn = "hospital_name";

    //Response related
    public static final String responseDataParameter = "data";
    public static final String responseDataSuburbParameter = "suburb";
    public static final String responseDataNumPagesParameter = "numPages";
    public static final String responseDataSuburbsParameter = "suburbs";
    public static final String responseDataHospitalsParameter = "hospitals";
    public static final String responseDataUniversitiesParameter = "universities";
    public static final String responseDataWikiParameter = "wikiSummary";
    public static final String responseDataNumResultsParameter = "numResults";
    public static final String responseMessageParameter = "message";
    public static final String invalidPageNumberParamMessage = "Invalid request: pageNo should be a number " +
            "with no decimals";
    public static final String invalidMaximumMedianPriceParamMessage = "Invalid request: mmp (maximum median price)" +
            " should be a whole number with no decimals";
    public static final String invalidStateParameterMessage = "Invalid request: Use VIC, NSW etc for state";
    public static final String invalidSortParameterMessage = "Invalid request: Use sortBy=rel or sortBy=dem for sortBy";
    public static final String invalidTypeParameterMessage = "Invalid request: Use type=house or type=unit for type";
    public static final String invalidSuburbIdMessage = "Invalid request: suburbId should be a number with no decimals";
    public static final String successfulResponseMessage = "Success";

    public static final int numSuburbs = 16125;

}
