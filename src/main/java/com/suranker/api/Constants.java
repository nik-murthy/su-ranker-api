package com.suranker.api;

public class Constants {

    //Request param related
    public static final String pageNumberParameter = "pageNo";
    public static final String stateParameter = "state";
    public static final String maximumMedianPriceParameter = "mmp";
    public static final String propertyTypeParameter = "type";
    public static final String propertyTypeHouse = "House";
    public static final String propertyTypeUnit = "Unit";
    public static final String defaultStateSelection = "All";
    public static final String defaultPageNo = "1";
    public static final String[] allowedStateValues = {"All", "NSW", "VIC", "QLD", "SA", "WA", "TAS", "NT"};

    //Entity related
    public static final String hospitalEntityName = "hospitals";
    public static final String hospitalIdColumn = "hospital_id";
    public static final String wikiSumaaryEntityName = "wikipedia_desc";
    public static final String suburbIdColumnName = "suburb_id";
    public static final String lgaEntityName = "lgas";
    public static final String lgaIdColumn = "lga_id";
    public static final String universitiesEntityName = "universities";
    public static final String universityIdColumn = "university_id";
    public static final String suburbsEntityName = "suburbs";
}
