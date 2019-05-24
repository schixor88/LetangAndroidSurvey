package com.kushagra.letang.test.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kushagra.letang.test.model.Details;
import com.kushagra.letang.test.model.Details2;
import com.kushagra.letang.test.model.FamilyMemberData;
import com.kushagra.letang.test.model.HouseholdData;
import com.kushagra.letang.test.model.ShiftedQuestion;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 21;
    private static final String DATABASE_NAME = "KUSHAGRA";
    private static final String TABLE_NAME = "Details";

    //
    private static final String KEY_ID = "Id";
    //
    private static final String KEY_PRADESH = " Pradesh";
    private static final String KEY_JILLA = "Jilla";
    private static final String KEY_NAGARPALIKA = " Nagarpalika";
    private static final String KEY_WARD = " Ward";
    private static final String KEY_BASTI = "Basti";
    private static final String KEY_TOLENAME = "Tole";
    private static final String KEY_SADAKNAME = "Sadak";

    //
    private static final String KEY_LAT = "Latitude";   //achhansaw
    private static final String KEY_LNG = "Longitude";  //desantar
    private static final String KEY_ALT = "Altitude";
    private static final String KEY_HOUSE_CODE = "HouseCode";

    private static final String KEY_GHARDHANINAME = "GhardhaniName";
    private static final String KEY_GHARDHANISEX = "GhardhaniSex";
    private static final String KEY_GHARDHANIPHONE = "GhardhaniPhone";

    //
    private static final String KEY_TENANT_FAMILY_COUNT = "tenant_family_count";
    private static final String KEY_HOME_BUSINESS = "home_business";
    private static final String KEY_INFORMER_NAME = "informer_name";
    private static final String KEY_INFORMER_GENDER = "informer_gender";
    private static final String KEY_INFORMER_AGE = "informer_age";
    private static final String KEY_INFORMER_EMAIL = "informer_email";
    private static final String KEY_SWAMITTO = "ghar_swamitto";
    private static final String KEY_BASAI_ABADHI = "basai_abadhi";
    private static final String KEY_JATIYA_SAMUHA = "jatiya_samuha";
    private static final String KEY_JATJATI = "jatjati";
    private static final String KEY_DHARMA = "dharma";
    private static final String KEY_MATRIBHASHA = "matribhasha";
    private static final String KEY_PARIWAR_BASOBAS_AVASTHA = "pariwar_basobas_avastha";
    private static final String KEY_KUN_STHAN_BATA_BASAI_SAREKO = "kun_sthan_bata_basai_sareko";
    private static final String KEY_BASAI_SARNU_KARAN = "basai_sarnu_karan";
    private static final String KEY_BASAI_AVADHI = "basai_avadhi";
    private static final String KEY_NAGARPALIKA_MA_GHAR_BHAYEKO = "nagarpalika_ma_ghar_bhayeko";
    private static final String KEY_GHAR_JAGGA_SWAMITTO_KISIM = "ghar_jagga_swamitto_kisim";
    private static final String KEY_JAGGA_KO_AREA = "jagga_ko_area";
    private static final String KEY_SICHAI_JAGGA_KO_AREA = "sichai_jagga_ko_area";
    private static final String KEY_NAGARPALIKA_MA_ANYA_GHAR_BHAYEKO = "nagarpalika_ma_anya_ghar_bhayeko";
    private static final String KEY_ANYA_GHAR_K_KO_LAGI = "anya_ghar_k_ko_lagi";

    private static final String KEY_OWNSLAND = "ownsLand";
    private static final String KEY_LANDLOCATION = "landLocation";
    private static final String KEY_LANDOWNEDBY = "landOwnedBy";
    private static final String KEY_LANDUSEDAS = "landUsedAs";
    private static final String KEY_LANDONLEASE = "landOnLease";
    private static final String KEY_LANDONLEASEUSEDAS = "landOnLeaseUsedAs";

    private static final String KEY_GHAR_KO_PRAKAR = "ghar_ko_prakar";
    private static final String KEY_GHAR_EARTHQUAKE_PROOF = "ghar_earthquake_proof";
    private static final String KEY_GHAR_ROOF_TYPE = "ghar_roof_type";
    private static final String KEY_KITCHEN_ALAGGAI_BHAYEKO = "kitchen_alaggai_bhayeko";
    private static final String KEY_KARESOBARI_BHAYEKO = "karesobari_bhayeko";

    private static final String KEY_GHAR_NIRMAN_AVASTHA = "ghar_nirman_avastha";
    private static final String KEY_GHAR_NIRMAN_BARSA = "ghar_nirman_barsa";
    private static final String KEY_BATTI_MAIN_SOURCE = "batti_main_source";
    private static final String KEY_ELECTRICITY_JADAN_BHAYEKO = "electricity_jadan_bhayeko";
    private static final String KEY_ELECTRICITY_JADAN_KINA_NABHAYEKO = "electricity_jadan_kina_nabhayeko";
    private static final String KEY_CHULO_KO_PRAKAR = "chulo_ko_prakar";
    private static final String KEY_PAKAUNE_FUEL = "pakaune_fuel";
    private static final String KEY_DAAURA_KO_SOURCE = "daaura_ko_source";
    private static final String KEY_GAS_CYLINDER_TIKNE_DIN = "gas_cylinder_tikne_din";
    private static final String KEY_OLD_CHULO_KO_LAGI_DAAURA_KG = "old_chulo_ko_lagi_daaura_kg";
    private static final String KEY_MODERN_CHULO_KO_LAGI_DAAURA_KG = "modern_chulo_ko_lagi_daaura_kg";
    private static final String KEY_MATTITEL_PERMONTH_LITRE = "mattitel_permonth_litre";
    private static final String KEY_INDUCTION_HEATER_HOURSPERDAY = "induction_heater_hoursperday";
    private static final String KEY_OVEN_HOURSPERDAY = "oven_hoursperday";
    private static final String KEY_PAANI_TATAUNA_CYLINDERPERYEAR = "paani_tatauna_cylinderperyear";
    private static final String KEY_PAANI_TATAUNA_WOOD_KGPERMONTH_OLD_CHULO = "paani_tatauna_wood_kgpermonth_old_chulo";
    private static final String KEY_PAANI_TATAUNA_WOOD_KGPERMONTH_MODERN = "paani_tatauna_wood_kgpermonth_modern";
    private static final String KEY_PAANI_TATAUNA_MATTITEL_PERMONTH = "paani_tatauna_mattitel_permonth";
    private static final String KEY_PAANI_TATAUNA_INDUCTION_HOURSPERDAY = "paani_tatauna_induction_hoursperday";
    private static final String KEY_PAANI_TATAUNA_OVEN_HOURSPERDAY = "paani_tatauna_oven_hoursperday";
    private static final String KEY_ROOM_HEATING_UPAKARAN = "room_heating_upakaran";
    private static final String KEY_ROOM_COOLING_UPAKARAN = "room_cooling_upakaran";
    private static final String KEY_FAN_COUNT = "fan_count";
    private static final String KEY_FAN_HOURSPERDAY = "fan_hoursperday";
    private static final String KEY_AIRCONDITION_COUNT = "aircondition_count";
    private static final String KEY_AIRCONDITION_HOURSPERDAY = "aircondition_hoursperday";
    private static final String KEY_BIJULI_UNIT = "bijuli_unit_kwh";
    private static final String KEY_WASHINGMACHINE_COUNT = "washingmachine_count";
    private static final String KEY_FRIDGE_COUNT = "fridge_count";
    private static final String KEY_SOLAR_COUNT = "solar_count";
    private static final String KEY_VACUUM_COUNT = "vacuum_count";
    private static final String KEY_INVERTER_COUNT = "inverter_count";
    private static final String KEY_GENERATOR_COUNT = "generator_count";
    private static final String KEY_DISHWASHER_COUNT = "dishwasher_count";
    private static final String KEY_CABLE_COUNT = "cable_count";
    private static final String KEY_OTHER_HOUSE_GADGET_COUNT = "other_house_gadget_name_count";
    private static final String KEY_RADIO_COUNT = "radio_count";
    private static final String KEY_TELEVISION_COUNT = "television_count";
    private static final String KEY_TELEPHONE_COUNT = "telephone_count";
    private static final String KEY_CELLPHONE_COUNT = "cellphone_count";
    private static final String KEY_SMARTPHONE_COUNT = "smartphone_count";
    private static final String KEY_COMPUTER_LAPTOP_COUNT = "computer_laptop_count";
    private static final String KEY_INTERNET_COUNT = "internet_count";
    private static final String KEY_OTHER_COMMUNICATION_COUNT = "other_communication_name_count";
    private static final String KEY_INTERNET_SPEED_MBPS = "internet_speed_mbps";

    private static final String KEY_CYCLE_COUNT = "cycle_count";
    private static final String KEY_BIKE_COUNT = "bike_count";
    private static final String KEY_LIGHTWEIGHT_VEHICLE_COUNT = "lightweight_vehicle_count";
    private static final String KEY_HEAVYWEIGHT_VEHICLE_COUNT = "heavyweight_vehicle_count";
    private static final String KEY_PUBLIC_TRANSPORT_VEHICLE_COUNT = "public_transport_vehicle_count";
    private static final String KEY_FAMILY_MA_YATAYAT_LICENSE_BHAYEKO = "family_ma_yatayat_license_bhayeko";
    private static final String KEY_LICENSE_BHAYEKO_COUNT = "license_bhayeko_count";
    private static final String KEY_LICENSE_COUNT_2_WHEELER = "license_count_2_wheeler";
    private static final String KEY_LICENSE_COUNT_4_WHEELER = "license_count_4_wheeler";

    private static final String KEY_ONE_YEAR_MA_BIRAMI = "one_year_ma_biramibi_bhayeko";
    private static final String KEY_BIRAMI_HUDA_KATA_LAGEKO = "birami_huda_kata_lageko";
    private static final String KEY_HEALTHPOST_JANA_HIDERA_TIME = "healthpost_jana_hidera_time";
    private static final String KEY_HEALTHPOST_JANA_GAADI_TIME = "healthpost_jana_gaadi_time";
    private static final String KEY_TWO_YEAR_LE_VACCINE_LAGAYEKO = "two_year_le_vaccine_lagayeko";
    private static final String KEY_VACCINE_NAGAREKO_KARAN = "vaccine_nagareko_karan";
    private static final String KEY_TWO_YEAR_MA_PREGNANT = "two_year_ma_pregnant";
    private static final String KEY_PREGNANT_KO_HEALTH_CHECKUP = "pregnant_ko_health_checkup";
    private static final String KEY_PREGNANT_KO_CHECK_NAGARNE_KARAN = "pregnant_ko_check_nagarne_karan";
    private static final String KEY_PREGNANT_KO_CHECK_GAREKO_COUNT = "pregnant_ko_check_gareko_count";
    private static final String KEY_PREGNANT_LE_ICON_PILL_LINEGAREKO = "pregnant_le_iron_pill_linegareko";
    private static final String KEY_PREGNANT_LE_JUKA_MEDICINE_LINEGAREKO = "pregnant_le_juka_medicine_linegareko";
    private static final String KEY_PREGNANT_LE_VITAMIN_LINEGAREKO = "pregnant_le_vitamin_linegareko";
    private static final String KEY_BACCHA_JANMAAUNE_STHAN = "baccha_janmaaune_sthan";
    private static final String KEY_BACCHA_JANMAAUNA_SAHAYOG_GARNE = "baccha_janmaauna_sahayog_garne";
    private static final String KEY_BACCHA_JANMAAUNA_HELP_NALINUKARAN = "baccha_janmaauna_help_nalinukaran";
    private static final String KEY_LAST12MONTHMA_UNDER_5YR_KO_DEATH = "last12Monthma_under_5yr_ko_death";
    private static final String KEY_UNDER_5YR_DEATH_GENDER = "under_5yr_death_gender";
    private static final String KEY_UNDER_5YR_DEATH_AGE = "under_5yr_death_age";
    private static final String KEY_UNDER_5YR_DEATH_KARAN = "under_5yr_death_karan";
    private static final String KEY_UNDER_5YR_KO_DEVELOPMENT_MEASURE_HUNCHA = "under_5yr_ko_development_measure_huncha";
    private static final String KEY_AGE6MONTH_TO_6YR_VITAMIN_A = "age6month_to_6yr_vitamin_A";
    private static final String KEY_AGE1YR_TO_6YR_JUKA_MEDICINE = "age1yr_to_6yr_juka_medicine";
    private static final String KEY_WINTER_MA_WARM_CLOTH = "winter_ma_warm_cloth";
    private static final String KEY_JHUUL_KO_BABYASTHA = "jhuul_ko_babyastha";
    private static final String KEY_REGULAR_HEALTH_CHECKUP_PERYEAR = "regular_health_checkup_peryear";
    private static final String KEY_PAST12MONTH_MA_DEATH_BHAYEKO = "past12month_ma_death_bhayeko";
    private static final String KEY_YOG_RA_ADHYATMIK_KENDRA_MA_JANEGAREKO = "yog_ra_adhyatmik_kendra_ma_janegareko";
    private static final String KEY_HEALTH_INSURANCE_GAREKO = "health_insurance_gareko";

    private static final String KEY_THAP_PANI_KINNUPARNE = "thap_pani_kinnuparne";
    private static final String KEY_PAANI_AAUNE_ABADHI = "paani_aaune_abadhi";
    private static final String KEY_PANI_BITARAN_GHANTA = "pani_bitaran_ghanta";
    private static final String KEY_KHANEPAANI_SOURCE = "khanepaani_source";
    private static final String KEY_PAANI_METER_JADAN_GAREYEKO = "paani_meter_jadan_gareyeko";
    private static final String KEY_PAANI_SUFFICIENT_HUNE = "paani_sufficient_hune";
    private static final String KEY_PAANI_LINA_JANE_AAUNE_TIME = "paani_lina_jane_aaune_time";
    private static final String KEY_KHANEPAANI_QUALITY = "khanepaani_quality";
    private static final String KEY_PANI_PURIFY_GARNE_GAREKO = "pani_purify_garne_gareko";
    private static final String KEY_PANI_PURIFY_GARNE_TARIKA = "pani_purify_garne_tarika";
    private static final String KEY_RAIN_WATER_COLLECT_GAREKO = "rain_water_collect_gareko";
    private static final String KEY_RAINWATER_KO_USE = "rainwater_ko_use";
    private static final String KEY_GHAAR_MA_DHAAL_ATTACH_BHAYEKO = "ghaar_ma_dhaal_attach_bhayeko";
    private static final String KEY_DHAAL_ATTACH_BHAYEKO_TYPE = "dhaal_attach_bhayeko_type";
    private static final String KEY_WASTE_WATER_MANAGEMENT = "waste_water_management";
    private static final String KEY_DECOMPOSE_NODECOMPOSE_SEPARATE_GARNE = "decompose_nodecompose_separate_garne";
    private static final String KEY_SOLID_WASTE_MANAGEMENT = "solid_waste_management";

    // Household Data
    private static final String KEY_HASTOILET = "hasToilet";
    private static final String KEY_TOILETTYPE = "toiletType";
    private static final String KEY_TOILET_KAHA_BHAYEKO = "toilet_kaha_bhayeko";
    private static final String KEY_TOILETWASTEMGMT = "toiletWasteMgmt";
    private static final String KEY_ONLINESERVICES = "onlineServices";
    private static final String KEY_PRIMARYINCOMESOURCE = "primaryIncomeSource";

    private static final String KEY_PRIMARYAGROPRODUCTIONS = "primaryAgroProductions";
    private static final String KEY_ANNABALI_MURI = "annabali_kg";
    private static final String KEY_DHAN_MURI = "dhan_kg";
    private static final String KEY_MAKAI_MURI = "makai_kg";
    private static final String KEY_KODO_MURI = "kodo_kg";
    private static final String KEY_GHAU_MURI = "ghau_kg";
    private static final String KEY_FAPAR_MURI = "fapar_kg";
    private static final String KEY_OIL_KG = "oil_kg";
    private static final String KEY_DAAL_KG = "daal_kg";
    private static final String KEY_TARKARI_KG = "tarkari_kg";
    private static final String KEY_FRESHTARKARI_KG = "freshTarkari_kg";
    private static final String KEY_AALU_KG = "aalu_kg";
    private static final String KEY_MASALA_KG = "masala_kg";
    private static final String KEY_FALFUL_KG = "falful_kg";
    private static final String KEY_KANDAMUL_KG = "kandamul_kg";
    private static final String KEY_ALAUCHI_KG = "alaichi_kg";
    private static final String KEY_SUPARI_KG = "supari_kg";
    private static final String KEY_AMRISHO_KG = "amrisho_kg";
    private static final String KEY_ADUWA_KG = "aduwa_kg";
    private static final String KEY_AKABARE_KG = "akabare_kg";
    private static final String KEY_COFFEE_KG = "coffee_kg";

    private static final String KEY_OTHERS_KG = "others_kg";
    private static final String KEY_COW_STHANIYA = "cow_sthaniya";
    private static final String KEY_COW_UNNAT = "cow_unnat";
    private static final String KEY_BUFFALO_STHANIYA = "buffalo_sthaniya";
    private static final String KEY_BUFFALO_UNNAT = "buffalo_unnat";
    private static final String KEY_GOAT_STHANIYA = "goat_sthaniya";
    private static final String KEY_GOAT_UNNAT = "goat_unnat";
    private static final String KEY_SHEEP_STHANIYA = "sheep_sthaniya";
    private static final String KEY_SHEEP_UNNAT = "sheep_unnat";
    private static final String KEY_PIG_STHANIYA = "pig_sthaniya";
    private static final String KEY_PIG_UNNAT = "pig_unnat";
    private static final String KEY_OTHER_ANIMAL = "other_animal";
    private static final String KEY_HEN_STHANIYA = "hen_sthaniya";
    private static final String KEY_HEN_UNNAT = "hen_unnat";
    private static final String KEY_PIGEON_COUNT = "pigeon_count";
    private static final String KEY_OTHER_BIRDS = "other_birds";
    private static final String KEY_FISH_COUNT = "fish_count";
    private static final String KEY_FISH_POND_AREA = "fish_pond_area";
    private static final String KEY_BEEHIVE_COUNT = "beehive_count";
    private static final String KEY_OTHER_PASUPANCHI = "other_pasupanchi";

    private static final String KEY_MILKCURD_LITRE = "milkCurd_litre";
    private static final String KEY_GHEE_KG = "ghee_kg";
    private static final String KEY_OTHERDAIRY_KG = "otherDairy_kg";
    private static final String KEY_MEAT_KG = "meat_kg";
    private static final String KEY_COMPOST_QUINTAL = "compost_quintal";
    private static final String KEY_URINE_LITRE = "urine_litre";
    private static final String KEY_WOOL_KG = "wool_kg";
    private static final String KEY_EGG_CRATE = "egg_count";
    private static final String KEY_FISH_KG = "fish_kg";
    private static final String KEY_HONEY_KG = "honey_kg";
    private static final String KEY_OTHER_PRODUCTION_KG = "other_production_kg";

    private static final String KEY_SELLSPRODUCTIONS = "sellsProductions";
    private static final String KEY_SELLPRODUCTIONLIST = "sellProductionList";
    private static final String KEY_SELLPRODUCTIONTO = "sellProductionTo";
    private static final String KEY_HASFRUITPLANTS = "hasFruitPlants";
    private static final String KEY_HASVEGETABLECROPS = "hasVegetableCrops";
    private static final String KEY_LASTYEARINCOME = "lastYearIncome";
    private static final String KEY_LASTYEAREXPENSE = "lastYearExpense";
    private static final String KEY_WORKSABROAD = "worksAbroad";
    private static final String KEY_REMITTANCESPENTON = "remittanceSpentOn";
    private static final String KEY_LASTYEARINVESTMENTS = "lastYearInvestments";
    private static final String KEY_PRODUCTIONSSUSTAINABLEFOR = "productionsSustainableFor";
    private static final String KEY_INCOMEISSUFFICIENT = "incomeIsSufficient";
    private static final String KEY_ADDITIONALCASHSOURCE = "additionalCashSource";
    private static final String KEY_HASTAKENLOAN = "hasTakenLoan";
    private static final String KEY_LOANSOURCE = "loanSource";
    private static final String KEY_TAKENLOANFOR = "takenLoanFor";
    private static final String KEY_DURATIONTOCLEARLOAN = "durationToClearLoan";
    private static final String KEY_KNOWSSAMHIT = "knowsSamhit";
    private static final String KEY_BUILTASPERSAMHIT = "builtAsPerSamhit";
    private static final String KEY_HASPERMISSIONBLUEPRINT = "hasPermissionBlueprint";
    private static final String KEY_HASSAFEZONENEARHOUSE = "hasSafeZoneNearHouse";
    private static final String KEY_HOUSESUSCEPTTOCALAMITY = "houseSusceptToCalamity";
    private static final String KEY_INFOABOUTEARTHQUAKE = "infoAboutEarthquake";
    private static final String KEY_KNOWSAFEZONEINHOME = "knowSafeZoneInHome";
    private static final String KEY_HASSUPPLIESFORSOE = "hasSuppliesForEmergency";
    private static final String KEY_AFFECTEDBYCALAMITIESLIST = "affectedByCalamitiesList";
    private static final String KEY_LASTMAJORDISASTERNAME = "lastMajorDisaster_name";
    private static final String KEY_LASTMAJORDISASTERYEAR = "lastMajorDisaster_year";
    private static final String KEY_LASTMAJORDISASTERDAMAGE = "lastMajorDisaster_damage";
    private static final String KEY_HASASSETINSURANCE = "hasAssetInsurance";
    private static final String KEY_ASSETSLISTWITHINSURANCE = "assetsListWithInsurance";
    private static final String KEY_STEPSTAKENTOMINIMIZEDISASTEREFFECTS = "stepsTakenToMinimizeDisasterEffects";
    private static final String KEY_ISVIOLENCEVICTIM = "isViolenceVictim";
    private static final String KEY_DEATHCOUNT = "deathCount";
    private static final String KEY_INJURYCOUNT = "injuryCount";
    private static final String KEY_MISSINGCOUNT = "missingCount";
    private static final String KEY_ASSETLOSSAMOUNTRS = "assetLossAmountRs";
    private static final String KEY_ISSUED = "isSued";
    private static final String KEY_ISSHIFTED = "bisthapitBhayeko";
    private static final String KEY_ISSEXUALLYABUSE = "isSexuallyAbuse";
    private static final String KEY_MEMBERMISSING = "memberMissing";
    private static final String KEY_FEELSSAFEINMUNICIPAL = "feelsSafeInMunicipal";
    private static final String KEY_REASONFEELSSAFE = "reasonFeelsSafe";
    private static final String KEY_REASONNOFEELSAFE = "reasonNoFeelSafe";
    private static final String KEY_WARDNOWHERENOTFEELSAFE = "wardNoWhereNotFeelSafe";
    private static final String KEY_REGIONNAMEWHERENOTFEELSAFE = "regionNameWhereNotFeelSafe";
    private static final String KEY_HOMEMEMBERUPTOAGE16WORKS = "homeMemberUptoAge16Works";
    private static final String KEY_UPTOAGE16WORINGBOYCOUNT = "uptoAge16WoringBoyCount";
    private static final String KEY_UPTOAGE16WORKINGGIRLCOUNT = "uptoAge16WorkingGirlCount";
    private static final String KEY_MEMBERUPTOAGE16HIREDWORK = "memberUptoAge16HiredWork";
    private static final String KEY_UPTOAGE16HIREDBOYCOUNT = "uptoAge16HiredBoyCount";
    private static final String KEY_UPTOAGE16HIREDGIRLCOUNT = "uptoAge16HiredGirlCount";
    private static final String KEY_CHILDRENISONBADINFLUENCE = "childrenIsOnBadInfluence";
    private static final String KEY_CHILDRENBADINFLUENCEON = "childrenBadInfluenceOn";
    private static final String KEY_WAYOFMAKINGFAMILYDECISION = "wayOfMakingFamilyDecision";
    private static final String KEY_ASSETSONFEMALENAME = "assetsOnFemaleName";
    private static final String KEY_ALLOWANCELISTTAKENBYFAMILY = "allowanceListTakenByFamily";
    private static final String KEY_MEMBERHASINVOLVEDONDEVELOPMENT = "memberHasInvolvedOnDevelopment";
    private static final String KEY_OPINIONONDEVELOPMENTPRIORITY = "opinionOnDevelopmentPriority";

    private static final String KEY_INCOMEAGRICULTURE = "incomeAgriculture";
    private static final String KEY_INCOMEBUSINESS = "incomeBusiness";
    private static final String KEY_INCOMESALARYPENSION = "incomeSalaryPension";
    private static final String KEY_INCOMESOCIALALLOWANCE = "incomeSocialAllowance";
    private static final String KEY_INCOMEFOREIGNEMP = "incomeForeignEmp";
    private static final String KEY_INCOMEWAGES = "incomeWages";
    private static final String KEY_INCOMERENT = "incomeRent";
    private static final String KEY_INCOMEINTERESTINVEST = "incomeInterestInvest";
    private static final String KEY_INCOMEOTHERS = "incomeOthers";
    private static final String KEY_EXPENSEFOOD = "expenseFood";
    private static final String KEY_EXPENSECLOTH = "expenseCloth";
    private static final String KEY_EXPENSEEDUCATION = "expenseEducation";
    private static final String KEY_EXPENSEHEALTH = "expenseHealth";
    private static final String KEY_EXPENSEENTERTAIN = "expenseEntertain";
    private static final String KEY_EXPENSERENT = "expenseRent";
    private static final String KEY_EXPENSEAGRICULTURE = "expenseAgriculture";
    private static final String KEY_EXPENSEINSTALLMENT = "expenseInstallment";
    private static final String KEY_EXPENSEFUEL = "expenseFuel";
    private static final String KEY_EXPENSETRANPORT = "expenseTranport";
    private static final String KEY_EXPENSEOTHERS = "expenseOthers";

    private static final String KEY_KUNAI_MEMBER_KO_BANK_ACCOUNT = "kunai_member_ko_bank_account";
    private static final String KEY_DISABILITY_COUNT = "disability_count";
    private static final String KEY_DISABILITY_TYPES = "disability_types";
    private static final String KEY_DISABILITY_CARD_COUNT = "disability_card_count";
    private static final String KEY_FAMILY_DISEASE_12MONTH = "family_disease_12month";
    private static final String KEY_FAMILY_DIRGA_ROG = "family_dirga_rog";
    private static final String KEY_FAMILY_DIRGA_ROG_LIST = "family_dirga_rog_list";
    private static final String KEY_FAMILY_SARUWA_ROG = "family_saruwa_rog";
    private static final String KEY_FAMILY_SARUWA_ROG_LIST = "family_saruwa_rog_list";
    private static final String KEY_FAMILY_NAGARIK_PASSPORT_PENSION_JANMADARTA_JAGGADHANI_EARTHQUAKECARD_COUNT = "family_nagarik_passport_pension_janmadarta_jaggadhani_earthquakecard_count";
    private static final String KEY_FAMILY_ALLOWANCE_DEPRIVED_COUNT = "family_allowance_deprived_count";
    private static final String KEY_UNMARRIED_MEMBER_COUNT = "unmarried_member_count";
    private static final String KEY_MARRIED_MEMBER_COUNT = "married_member_count";
    private static final String KEY_POLYGAMY_MEMBER_COUNT = "polygamy_member_count";
    private static final String KEY_REMARRIED_MEMBER_COUNT = "remarried_member_count";
    private static final String KEY_SINGLE_MEMBER_COUNT = "single_member_count";
    private static final String KEY_DIVORCED_MEMBER_COUNT = "divorced_member_count";
    private static final String KEY_BREAKUP_NOTDIVORCED_MEMBER_COUNT = "breakup_notdivorced_member_count";

    private static final String KEY_RAJNITIK_KENDRIA_LEVEL_COUNT = "rajnitik_kendria_level_count";
    private static final String KEY_RAJNITIK_PRADESH_LEVEL_COUNT = "rajnitik_pradesh_level_count";
    private static final String KEY_RAJNITIK_JILLA_LEVEL_COUNT = "rajnitik_jilla_level_count";
    private static final String KEY_RAJNITIK_PALIKA_LEVEL_COUNT = "rajnitik_palika_level_count";
    private static final String KEY_RAJNITIK_WARD_LEVEL_COUNT = "rajnitik_ward_level_count";

    private static final String KEY_BUSINESS_MEMBER_COUNT = "business_member_count";
    private static final String KEY_JOB_MEMBER_COUNT = "job_member_count";
    private static final String KEY_STUDY_MEMBER_COUNT = "study_member_count";


    private static final String KEY_FAMILY_COUNT = "family_member_count";

    private static final String MEMBER_1_KEY_NAME_THAR = "member_1_name_thar";
    private static final String MEMBER_1_KEY_GENDER = "member_1_gender";
    private static final String MEMBER_1_KEY_AGE = "member_1_age";
    private static final String MEMBER_1_KEY_RELATION_TO_OWNER = "member_1_relation_to_owner";
    private static final String MEMBER_1_KEY_LEAVE_HOME_6MONTH = "member_1_leave_home_6month";
    private static final String MEMBER_1_KEY_LEAVE_HOME_REASON = "member_1_leave_home_reason";
    private static final String MEMBER_1_KEY_EDUCATION = "member_1_education";
    private static final String MEMBER_1_KEY_SCHOOL_TYPE = "member_1_school_type";
    private static final String MEMBER_1_KEY_LEAVE_SCHOOL_REASON = "member_1_leave_school_reason";
    private static final String MEMBER_1_KEY_INCOME_SOURCE = "member_1_income_source";
    private static final String MEMBER_1_KEY_ABROAD_COUNTRY = "member_1_abroad_country";
    private static final String MEMBER_1_KEY_ABROAD_MONEYTRANSFER = "member_1_abroad_moneyTransfer";
    private static final String MEMBER_1_KEY_SKILLS = "member_1_skills";
    private static final String MEMBER_1_KEY_REGULARDEPOSIT = "member_1_regularDeposit";
    private static final String MEMBER_1_KEY_REGULARDEPOSIT_TO = "member_1_regularDeposit_to";
    private static final String MEMBER_1_KEY_USESVACCINE = "member_1_usesVaccine";
    private static final String MEMBER_1_KEY_SOCIALINVOLVEMENTS = "member_1_socialInvolvements";
    private static final String MEMBER_1_KEY_HASRECEIVEDTRAINING = "member_1_hasReceivedTraining";
    private static final String MEMBER_1_KEY_TRAININGLIST = "member_1_trainingList";
    private static final String MEMBER_1_KEY_TRAVELWORK = "member_1_travelWork";
    private static final String MEMBER_1_KEY_TRAVELWORKTO = "member_1_travelWorkTo";
    private static final String MEMBER_1_KEY_TRAVELBUSINESS = "member_1_travelBusiness";
    private static final String MEMBER_1_KEY_TRAVELBUSINESSTO = "member_1_travelBusinessTo";
    private static final String MEMBER_1_KEY_TRAVELEDUCATION = "member_1_travelEducation";
    private static final String MEMBER_1_KEY_TRAVELEDUCATIONTO = "member_1_travelEducationTo";
    private static final String MEMBER_1_KEY_TRAVELOTHERS = "member_1_travelOthers";
    private static final String MEMBER_1_KEY_TRAVELOTHERSTO = "member_1_travelOthersTo";

    private static final String MEMBER_2_KEY_NAME_THAR = "member_2_name_thar";
    private static final String MEMBER_2_KEY_GENDER = "member_2_gender";
    private static final String MEMBER_2_KEY_AGE = "member_2_age";
    private static final String MEMBER_2_KEY_RELATION_TO_OWNER = "member_2_relation_to_owner";
    private static final String MEMBER_2_KEY_LEAVE_HOME_6MONTH = "member_2_leave_home_6month";
    private static final String MEMBER_2_KEY_LEAVE_HOME_REASON = "member_2_leave_home_reason";
    private static final String MEMBER_2_KEY_EDUCATION = "member_2_education";
    private static final String MEMBER_2_KEY_SCHOOL_TYPE = "member_2_school_type";
    private static final String MEMBER_2_KEY_LEAVE_SCHOOL_REASON = "member_2_leave_school_reason";
    private static final String MEMBER_2_KEY_INCOME_SOURCE = "member_2_income_source";
    private static final String MEMBER_2_KEY_ABROAD_COUNTRY = "member_2_abroad_country";
    private static final String MEMBER_2_KEY_ABROAD_MONEYTRANSFER = "member_2_abroad_moneyTransfer";
    private static final String MEMBER_2_KEY_SKILLS = "member_2_skills";
    private static final String MEMBER_2_KEY_REGULARDEPOSIT = "member_2_regularDeposit";
    private static final String MEMBER_2_KEY_REGULARDEPOSIT_TO = "member_2_regularDeposit_to";
    private static final String MEMBER_2_KEY_USESVACCINE = "member_2_usesVaccine";
    private static final String MEMBER_2_KEY_SOCIALINVOLVEMENTS = "member_2_socialInvolvements";
    private static final String MEMBER_2_KEY_HASRECEIVEDTRAINING = "member_2_hasReceivedTraining";
    private static final String MEMBER_2_KEY_TRAININGLIST = "member_2_trainingList";
    private static final String MEMBER_2_KEY_TRAVELWORK = "member_2_travelWork";
    private static final String MEMBER_2_KEY_TRAVELWORKTO = "member_2_travelWorkTo";
    private static final String MEMBER_2_KEY_TRAVELBUSINESS = "member_2_travelBusiness";
    private static final String MEMBER_2_KEY_TRAVELBUSINESSTO = "member_2_travelBusinessTo";
    private static final String MEMBER_2_KEY_TRAVELEDUCATION = "member_2_travelEducation";
    private static final String MEMBER_2_KEY_TRAVELEDUCATIONTO = "member_2_travelEducationTo";
    private static final String MEMBER_2_KEY_TRAVELOTHERS = "member_2_travelOthers";
    private static final String MEMBER_2_KEY_TRAVELOTHERSTO = "member_2_travelOthersTo";

    private static final String MEMBER_3_KEY_NAME_THAR = "member_3_name_thar";
    private static final String MEMBER_3_KEY_GENDER = "member_3_gender";
    private static final String MEMBER_3_KEY_AGE = "member_3_age";
    private static final String MEMBER_3_KEY_RELATION_TO_OWNER = "member_3_relation_to_owner";
    private static final String MEMBER_3_KEY_LEAVE_HOME_6MONTH = "member_3_leave_home_6month";
    private static final String MEMBER_3_KEY_LEAVE_HOME_REASON = "member_3_leave_home_reason";
    private static final String MEMBER_3_KEY_EDUCATION = "member_3_education";
    private static final String MEMBER_3_KEY_SCHOOL_TYPE = "member_3_school_type";
    private static final String MEMBER_3_KEY_LEAVE_SCHOOL_REASON = "member_3_leave_school_reason";
    private static final String MEMBER_3_KEY_INCOME_SOURCE = "member_3_income_source";
    private static final String MEMBER_3_KEY_ABROAD_COUNTRY = "member_3_abroad_country";
    private static final String MEMBER_3_KEY_ABROAD_MONEYTRANSFER = "member_3_abroad_moneyTransfer";
    private static final String MEMBER_3_KEY_SKILLS = "member_3_skills";
    private static final String MEMBER_3_KEY_REGULARDEPOSIT = "member_3_regularDeposit";
    private static final String MEMBER_3_KEY_REGULARDEPOSIT_TO = "member_3_regularDeposit_to";
    private static final String MEMBER_3_KEY_USESVACCINE = "member_3_usesVaccine";
    private static final String MEMBER_3_KEY_SOCIALINVOLVEMENTS = "member_3_socialInvolvements";
    private static final String MEMBER_3_KEY_HASRECEIVEDTRAINING = "member_3_hasReceivedTraining";
    private static final String MEMBER_3_KEY_TRAININGLIST = "member_3_trainingList";
    private static final String MEMBER_3_KEY_TRAVELWORK = "member_3_travelWork";
    private static final String MEMBER_3_KEY_TRAVELWORKTO = "member_3_travelWorkTo";
    private static final String MEMBER_3_KEY_TRAVELBUSINESS = "member_3_travelBusiness";
    private static final String MEMBER_3_KEY_TRAVELBUSINESSTO = "member_3_travelBusinessTo";
    private static final String MEMBER_3_KEY_TRAVELEDUCATION = "member_3_travelEducation";
    private static final String MEMBER_3_KEY_TRAVELEDUCATIONTO = "member_3_travelEducationTo";
    private static final String MEMBER_3_KEY_TRAVELOTHERS = "member_3_travelOthers";
    private static final String MEMBER_3_KEY_TRAVELOTHERSTO = "member_3_travelOthersTo";

    private static final String MEMBER_4_KEY_NAME_THAR = "member_4_name_thar";
    private static final String MEMBER_4_KEY_GENDER = "member_4_gender";
    private static final String MEMBER_4_KEY_AGE = "member_4_age";
    private static final String MEMBER_4_KEY_RELATION_TO_OWNER = "member_4_relation_to_owner";
    private static final String MEMBER_4_KEY_LEAVE_HOME_6MONTH = "member_4_leave_home_6month";
    private static final String MEMBER_4_KEY_LEAVE_HOME_REASON = "member_4_leave_home_reason";
    private static final String MEMBER_4_KEY_EDUCATION = "member_4_education";
    private static final String MEMBER_4_KEY_SCHOOL_TYPE = "member_4_school_type";
    private static final String MEMBER_4_KEY_LEAVE_SCHOOL_REASON = "member_4_leave_school_reason";
    private static final String MEMBER_4_KEY_INCOME_SOURCE = "member_4_income_source";
    private static final String MEMBER_4_KEY_ABROAD_COUNTRY = "member_4_abroad_country";
    private static final String MEMBER_4_KEY_ABROAD_MONEYTRANSFER = "member_4_abroad_moneyTransfer";
    private static final String MEMBER_4_KEY_SKILLS = "member_4_skills";
    private static final String MEMBER_4_KEY_REGULARDEPOSIT = "member_4_regularDeposit";
    private static final String MEMBER_4_KEY_REGULARDEPOSIT_TO = "member_4_regularDeposit_to";
    private static final String MEMBER_4_KEY_USESVACCINE = "member_4_usesVaccine";
    private static final String MEMBER_4_KEY_SOCIALINVOLVEMENTS = "member_4_socialInvolvements";
    private static final String MEMBER_4_KEY_HASRECEIVEDTRAINING = "member_4_hasReceivedTraining";
    private static final String MEMBER_4_KEY_TRAININGLIST = "member_4_trainingList";
    private static final String MEMBER_4_KEY_TRAVELWORK = "member_4_travelWork";
    private static final String MEMBER_4_KEY_TRAVELWORKTO = "member_4_travelWorkTo";
    private static final String MEMBER_4_KEY_TRAVELBUSINESS = "member_4_travelBusiness";
    private static final String MEMBER_4_KEY_TRAVELBUSINESSTO = "member_4_travelBusinessTo";
    private static final String MEMBER_4_KEY_TRAVELEDUCATION = "member_4_travelEducation";
    private static final String MEMBER_4_KEY_TRAVELEDUCATIONTO = "member_4_travelEducationTo";
    private static final String MEMBER_4_KEY_TRAVELOTHERS = "member_4_travelOthers";
    private static final String MEMBER_4_KEY_TRAVELOTHERSTO = "member_4_travelOthersTo";

    private static final String MEMBER_5_KEY_NAME_THAR = "member_5_name_thar";
    private static final String MEMBER_5_KEY_GENDER = "member_5_gender";
    private static final String MEMBER_5_KEY_AGE = "member_5_age";
    private static final String MEMBER_5_KEY_RELATION_TO_OWNER = "member_5_relation_to_owner";
    private static final String MEMBER_5_KEY_LEAVE_HOME_6MONTH = "member_5_leave_home_6month";
    private static final String MEMBER_5_KEY_LEAVE_HOME_REASON = "member_5_leave_home_reason";
    private static final String MEMBER_5_KEY_EDUCATION = "member_5_education";
    private static final String MEMBER_5_KEY_SCHOOL_TYPE = "member_5_school_type";
    private static final String MEMBER_5_KEY_LEAVE_SCHOOL_REASON = "member_5_leave_school_reason";
    private static final String MEMBER_5_KEY_INCOME_SOURCE = "member_5_income_source";
    private static final String MEMBER_5_KEY_ABROAD_COUNTRY = "member_5_abroad_country";
    private static final String MEMBER_5_KEY_ABROAD_MONEYTRANSFER = "member_5_abroad_moneyTransfer";
    private static final String MEMBER_5_KEY_SKILLS = "member_5_skills";
    private static final String MEMBER_5_KEY_REGULARDEPOSIT = "member_5_regularDeposit";
    private static final String MEMBER_5_KEY_REGULARDEPOSIT_TO = "member_5_regularDeposit_to";
    private static final String MEMBER_5_KEY_USESVACCINE = "member_5_usesVaccine";
    private static final String MEMBER_5_KEY_SOCIALINVOLVEMENTS = "member_5_socialInvolvements";
    private static final String MEMBER_5_KEY_HASRECEIVEDTRAINING = "member_5_hasReceivedTraining";
    private static final String MEMBER_5_KEY_TRAININGLIST = "member_5_trainingList";
    private static final String MEMBER_5_KEY_TRAVELWORK = "member_5_travelWork";
    private static final String MEMBER_5_KEY_TRAVELWORKTO = "member_5_travelWorkTo";
    private static final String MEMBER_5_KEY_TRAVELBUSINESS = "member_5_travelBusiness";
    private static final String MEMBER_5_KEY_TRAVELBUSINESSTO = "member_5_travelBusinessTo";
    private static final String MEMBER_5_KEY_TRAVELEDUCATION = "member_5_travelEducation";
    private static final String MEMBER_5_KEY_TRAVELEDUCATIONTO = "member_5_travelEducationTo";
    private static final String MEMBER_5_KEY_TRAVELOTHERS = "member_5_travelOthers";
    private static final String MEMBER_5_KEY_TRAVELOTHERSTO = "member_5_travelOthersTo";

    private static final String MEMBER_6_KEY_NAME_THAR = "member_6_name_thar";
    private static final String MEMBER_6_KEY_GENDER = "member_6_gender";
    private static final String MEMBER_6_KEY_AGE = "member_6_age";
    private static final String MEMBER_6_KEY_RELATION_TO_OWNER = "member_6_relation_to_owner";
    private static final String MEMBER_6_KEY_LEAVE_HOME_6MONTH = "member_6_leave_home_6month";
    private static final String MEMBER_6_KEY_LEAVE_HOME_REASON = "member_6_leave_home_reason";
    private static final String MEMBER_6_KEY_EDUCATION = "member_6_education";
    private static final String MEMBER_6_KEY_SCHOOL_TYPE = "member_6_school_type";
    private static final String MEMBER_6_KEY_LEAVE_SCHOOL_REASON = "member_6_leave_school_reason";
    private static final String MEMBER_6_KEY_INCOME_SOURCE = "member_6_income_source";
    private static final String MEMBER_6_KEY_ABROAD_COUNTRY = "member_6_abroad_country";
    private static final String MEMBER_6_KEY_ABROAD_MONEYTRANSFER = "member_6_abroad_moneyTransfer";
    private static final String MEMBER_6_KEY_SKILLS = "member_6_skills";
    private static final String MEMBER_6_KEY_REGULARDEPOSIT = "member_6_regularDeposit";
    private static final String MEMBER_6_KEY_REGULARDEPOSIT_TO = "member_6_regularDeposit_to";
    private static final String MEMBER_6_KEY_USESVACCINE = "member_6_usesVaccine";
    private static final String MEMBER_6_KEY_SOCIALINVOLVEMENTS = "member_6_socialInvolvements";
    private static final String MEMBER_6_KEY_HASRECEIVEDTRAINING = "member_6_hasReceivedTraining";
    private static final String MEMBER_6_KEY_TRAININGLIST = "member_6_trainingList";
    private static final String MEMBER_6_KEY_TRAVELWORK = "member_6_travelWork";
    private static final String MEMBER_6_KEY_TRAVELWORKTO = "member_6_travelWorkTo";
    private static final String MEMBER_6_KEY_TRAVELBUSINESS = "member_6_travelBusiness";
    private static final String MEMBER_6_KEY_TRAVELBUSINESSTO = "member_6_travelBusinessTo";
    private static final String MEMBER_6_KEY_TRAVELEDUCATION = "member_6_travelEducation";
    private static final String MEMBER_6_KEY_TRAVELEDUCATIONTO = "member_6_travelEducationTo";
    private static final String MEMBER_6_KEY_TRAVELOTHERS = "member_6_travelOthers";
    private static final String MEMBER_6_KEY_TRAVELOTHERSTO = "member_6_travelOthersTo";

    private static final String MEMBER_7_KEY_NAME_THAR = "member_7_name_thar";
    private static final String MEMBER_7_KEY_GENDER = "member_7_gender";
    private static final String MEMBER_7_KEY_AGE = "member_7_age";
    private static final String MEMBER_7_KEY_RELATION_TO_OWNER = "member_7_relation_to_owner";
    private static final String MEMBER_7_KEY_LEAVE_HOME_6MONTH = "member_7_leave_home_6month";
    private static final String MEMBER_7_KEY_LEAVE_HOME_REASON = "member_7_leave_home_reason";
    private static final String MEMBER_7_KEY_EDUCATION = "member_7_education";
    private static final String MEMBER_7_KEY_SCHOOL_TYPE = "member_7_school_type";
    private static final String MEMBER_7_KEY_LEAVE_SCHOOL_REASON = "member_7_leave_school_reason";
    private static final String MEMBER_7_KEY_INCOME_SOURCE = "member_7_income_source";
    private static final String MEMBER_7_KEY_ABROAD_COUNTRY = "member_7_abroad_country";
    private static final String MEMBER_7_KEY_ABROAD_MONEYTRANSFER = "member_7_abroad_moneyTransfer";
    private static final String MEMBER_7_KEY_SKILLS = "member_7_skills";
    private static final String MEMBER_7_KEY_REGULARDEPOSIT = "member_7_regularDeposit";
    private static final String MEMBER_7_KEY_REGULARDEPOSIT_TO = "member_7_regularDeposit_to";
    private static final String MEMBER_7_KEY_USESVACCINE = "member_7_usesVaccine";
    private static final String MEMBER_7_KEY_SOCIALINVOLVEMENTS = "member_7_socialInvolvements";
    private static final String MEMBER_7_KEY_HASRECEIVEDTRAINING = "member_7_hasReceivedTraining";
    private static final String MEMBER_7_KEY_TRAININGLIST = "member_7_trainingList";
    private static final String MEMBER_7_KEY_TRAVELWORK = "member_7_travelWork";
    private static final String MEMBER_7_KEY_TRAVELWORKTO = "member_7_travelWorkTo";
    private static final String MEMBER_7_KEY_TRAVELBUSINESS = "member_7_travelBusiness";
    private static final String MEMBER_7_KEY_TRAVELBUSINESSTO = "member_7_travelBusinessTo";
    private static final String MEMBER_7_KEY_TRAVELEDUCATION = "member_7_travelEducation";
    private static final String MEMBER_7_KEY_TRAVELEDUCATIONTO = "member_7_travelEducationTo";
    private static final String MEMBER_7_KEY_TRAVELOTHERS = "member_7_travelOthers";
    private static final String MEMBER_7_KEY_TRAVELOTHERSTO = "member_7_travelOthersTo";

    private static final String MEMBER_8_KEY_NAME_THAR = "member_8_name_thar";
    private static final String MEMBER_8_KEY_GENDER = "member_8_gender";
    private static final String MEMBER_8_KEY_AGE = "member_8_age";
    private static final String MEMBER_8_KEY_RELATION_TO_OWNER = "member_8_relation_to_owner";
    private static final String MEMBER_8_KEY_LEAVE_HOME_6MONTH = "member_8_leave_home_6month";
    private static final String MEMBER_8_KEY_LEAVE_HOME_REASON = "member_8_leave_home_reason";
    private static final String MEMBER_8_KEY_EDUCATION = "member_8_education";
    private static final String MEMBER_8_KEY_SCHOOL_TYPE = "member_8_school_type";
    private static final String MEMBER_8_KEY_LEAVE_SCHOOL_REASON = "member_8_leave_school_reason";
    private static final String MEMBER_8_KEY_INCOME_SOURCE = "member_8_income_source";
    private static final String MEMBER_8_KEY_ABROAD_COUNTRY = "member_8_abroad_country";
    private static final String MEMBER_8_KEY_ABROAD_MONEYTRANSFER = "member_8_abroad_moneyTransfer";
    private static final String MEMBER_8_KEY_SKILLS = "member_8_skills";
    private static final String MEMBER_8_KEY_REGULARDEPOSIT = "member_8_regularDeposit";
    private static final String MEMBER_8_KEY_REGULARDEPOSIT_TO = "member_8_regularDeposit_to";
    private static final String MEMBER_8_KEY_USESVACCINE = "member_8_usesVaccine";
    private static final String MEMBER_8_KEY_SOCIALINVOLVEMENTS = "member_8_socialInvolvements";
    private static final String MEMBER_8_KEY_HASRECEIVEDTRAINING = "member_8_hasReceivedTraining";
    private static final String MEMBER_8_KEY_TRAININGLIST = "member_8_trainingList";
    private static final String MEMBER_8_KEY_TRAVELWORK = "member_8_travelWork";
    private static final String MEMBER_8_KEY_TRAVELWORKTO = "member_8_travelWorkTo";
    private static final String MEMBER_8_KEY_TRAVELBUSINESS = "member_8_travelBusiness";
    private static final String MEMBER_8_KEY_TRAVELBUSINESSTO = "member_8_travelBusinessTo";
    private static final String MEMBER_8_KEY_TRAVELEDUCATION = "member_8_travelEducation";
    private static final String MEMBER_8_KEY_TRAVELEDUCATIONTO = "member_8_travelEducationTo";
    private static final String MEMBER_8_KEY_TRAVELOTHERS = "member_8_travelOthers";
    private static final String MEMBER_8_KEY_TRAVELOTHERSTO = "member_8_travelOthersTo";

    private static final String MEMBER_9_KEY_NAME_THAR = "member_9_name_thar";
    private static final String MEMBER_9_KEY_GENDER = "member_9_gender";
    private static final String MEMBER_9_KEY_AGE = "member_9_age";
    private static final String MEMBER_9_KEY_RELATION_TO_OWNER = "member_9_relation_to_owner";
    private static final String MEMBER_9_KEY_LEAVE_HOME_6MONTH = "member_9_leave_home_6month";
    private static final String MEMBER_9_KEY_LEAVE_HOME_REASON = "member_9_leave_home_reason";
    private static final String MEMBER_9_KEY_EDUCATION = "member_9_education";
    private static final String MEMBER_9_KEY_SCHOOL_TYPE = "member_9_school_type";
    private static final String MEMBER_9_KEY_LEAVE_SCHOOL_REASON = "member_9_leave_school_reason";
    private static final String MEMBER_9_KEY_INCOME_SOURCE = "member_9_income_source";
    private static final String MEMBER_9_KEY_ABROAD_COUNTRY = "member_9_abroad_country";
    private static final String MEMBER_9_KEY_ABROAD_MONEYTRANSFER = "member_9_abroad_moneyTransfer";
    private static final String MEMBER_9_KEY_SKILLS = "member_9_skills";
    private static final String MEMBER_9_KEY_REGULARDEPOSIT = "member_9_regularDeposit";
    private static final String MEMBER_9_KEY_REGULARDEPOSIT_TO = "member_9_regularDeposit_to";
    private static final String MEMBER_9_KEY_USESVACCINE = "member_9_usesVaccine";
    private static final String MEMBER_9_KEY_SOCIALINVOLVEMENTS = "member_9_socialInvolvements";
    private static final String MEMBER_9_KEY_HASRECEIVEDTRAINING = "member_9_hasReceivedTraining";
    private static final String MEMBER_9_KEY_TRAININGLIST = "member_9_trainingList";
    private static final String MEMBER_9_KEY_TRAVELWORK = "member_9_travelWork";
    private static final String MEMBER_9_KEY_TRAVELWORKTO = "member_9_travelWorkTo";
    private static final String MEMBER_9_KEY_TRAVELBUSINESS = "member_9_travelBusiness";
    private static final String MEMBER_9_KEY_TRAVELBUSINESSTO = "member_9_travelBusinessTo";
    private static final String MEMBER_9_KEY_TRAVELEDUCATION = "member_9_travelEducation";
    private static final String MEMBER_9_KEY_TRAVELEDUCATIONTO = "member_9_travelEducationTo";
    private static final String MEMBER_9_KEY_TRAVELOTHERS = "member_9_travelOthers";
    private static final String MEMBER_9_KEY_TRAVELOTHERSTO = "member_9_travelOthersTo";

    private static final String MEMBER_10_KEY_NAME_THAR = "member_10_name_thar";
    private static final String MEMBER_10_KEY_GENDER = "member_10_gender";
    private static final String MEMBER_10_KEY_AGE = "member_10_age";
    private static final String MEMBER_10_KEY_RELATION_TO_OWNER = "member_10_relation_to_owner";
    private static final String MEMBER_10_KEY_LEAVE_HOME_6MONTH = "member_10_leave_home_6month";
    private static final String MEMBER_10_KEY_LEAVE_HOME_REASON = "member_10_leave_home_reason";
    private static final String MEMBER_10_KEY_EDUCATION = "member_10_education";
    private static final String MEMBER_10_KEY_SCHOOL_TYPE = "member_10_school_type";
    private static final String MEMBER_10_KEY_LEAVE_SCHOOL_REASON = "member_10_leave_school_reason";
    private static final String MEMBER_10_KEY_INCOME_SOURCE = "member_10_income_source";
    private static final String MEMBER_10_KEY_ABROAD_COUNTRY = "member_10_abroad_country";
    private static final String MEMBER_10_KEY_ABROAD_MONEYTRANSFER = "member_10_abroad_moneyTransfer";
    private static final String MEMBER_10_KEY_SKILLS = "member_10_skills";
    private static final String MEMBER_10_KEY_REGULARDEPOSIT = "member_10_regularDeposit";
    private static final String MEMBER_10_KEY_REGULARDEPOSIT_TO = "member_10_regularDeposit_to";
    private static final String MEMBER_10_KEY_USESVACCINE = "member_10_usesVaccine";
    private static final String MEMBER_10_KEY_SOCIALINVOLVEMENTS = "member_10_socialInvolvements";
    private static final String MEMBER_10_KEY_HASRECEIVEDTRAINING = "member_10_hasReceivedTraining";
    private static final String MEMBER_10_KEY_TRAININGLIST = "member_10_trainingList";
    private static final String MEMBER_10_KEY_TRAVELWORK = "member_10_travelWork";
    private static final String MEMBER_10_KEY_TRAVELWORKTO = "member_10_travelWorkTo";
    private static final String MEMBER_10_KEY_TRAVELBUSINESS = "member_10_travelBusiness";
    private static final String MEMBER_10_KEY_TRAVELBUSINESSTO = "member_10_travelBusinessTo";
    private static final String MEMBER_10_KEY_TRAVELEDUCATION = "member_10_travelEducation";
    private static final String MEMBER_10_KEY_TRAVELEDUCATIONTO = "member_10_travelEducationTo";
    private static final String MEMBER_10_KEY_TRAVELOTHERS = "member_10_travelOthers";
    private static final String MEMBER_10_KEY_TRAVELOTHERSTO = "member_10_travelOthersTo";

    private static final String MEMBER_11_KEY_NAME_THAR = "member_11_name_thar";
    private static final String MEMBER_11_KEY_GENDER = "member_11_gender";
    private static final String MEMBER_11_KEY_AGE = "member_11_age";
    private static final String MEMBER_11_KEY_RELATION_TO_OWNER = "member_11_relation_to_owner";
    private static final String MEMBER_11_KEY_LEAVE_HOME_6MONTH = "member_11_leave_home_6month";
    private static final String MEMBER_11_KEY_LEAVE_HOME_REASON = "member_11_leave_home_reason";
    private static final String MEMBER_11_KEY_EDUCATION = "member_11_education";
    private static final String MEMBER_11_KEY_SCHOOL_TYPE = "member_11_school_type";
    private static final String MEMBER_11_KEY_LEAVE_SCHOOL_REASON = "member_11_leave_school_reason";
    private static final String MEMBER_11_KEY_INCOME_SOURCE = "member_11_income_source";
    private static final String MEMBER_11_KEY_ABROAD_COUNTRY = "member_11_abroad_country";
    private static final String MEMBER_11_KEY_ABROAD_MONEYTRANSFER = "member_11_abroad_moneyTransfer";
    private static final String MEMBER_11_KEY_SKILLS = "member_11_skills";
    private static final String MEMBER_11_KEY_REGULARDEPOSIT = "member_11_regularDeposit";
    private static final String MEMBER_11_KEY_REGULARDEPOSIT_TO = "member_11_regularDeposit_to";
    private static final String MEMBER_11_KEY_USESVACCINE = "member_11_usesVaccine";
    private static final String MEMBER_11_KEY_SOCIALINVOLVEMENTS = "member_11_socialInvolvements";
    private static final String MEMBER_11_KEY_HASRECEIVEDTRAINING = "member_11_hasReceivedTraining";
    private static final String MEMBER_11_KEY_TRAININGLIST = "member_11_trainingList";
    private static final String MEMBER_11_KEY_TRAVELWORK = "member_11_travelWork";
    private static final String MEMBER_11_KEY_TRAVELWORKTO = "member_11_travelWorkTo";
    private static final String MEMBER_11_KEY_TRAVELBUSINESS = "member_11_travelBusiness";
    private static final String MEMBER_11_KEY_TRAVELBUSINESSTO = "member_11_travelBusinessTo";
    private static final String MEMBER_11_KEY_TRAVELEDUCATION = "member_11_travelEducation";
    private static final String MEMBER_11_KEY_TRAVELEDUCATIONTO = "member_11_travelEducationTo";
    private static final String MEMBER_11_KEY_TRAVELOTHERS = "member_11_travelOthers";
    private static final String MEMBER_11_KEY_TRAVELOTHERSTO = "member_11_travelOthersTo";

    private static final String MEMBER_12_KEY_NAME_THAR = "member_12_name_thar";
    private static final String MEMBER_12_KEY_GENDER = "member_12_gender";
    private static final String MEMBER_12_KEY_AGE = "member_12_age";
    private static final String MEMBER_12_KEY_RELATION_TO_OWNER = "member_12_relation_to_owner";
    private static final String MEMBER_12_KEY_LEAVE_HOME_6MONTH = "member_12_leave_home_6month";
    private static final String MEMBER_12_KEY_LEAVE_HOME_REASON = "member_12_leave_home_reason";
    private static final String MEMBER_12_KEY_EDUCATION = "member_12_education";
    private static final String MEMBER_12_KEY_SCHOOL_TYPE = "member_12_school_type";
    private static final String MEMBER_12_KEY_LEAVE_SCHOOL_REASON = "member_12_leave_school_reason";
    private static final String MEMBER_12_KEY_INCOME_SOURCE = "member_12_income_source";
    private static final String MEMBER_12_KEY_ABROAD_COUNTRY = "member_12_abroad_country";
    private static final String MEMBER_12_KEY_ABROAD_MONEYTRANSFER = "member_12_abroad_moneyTransfer";
    private static final String MEMBER_12_KEY_SKILLS = "member_12_skills";
    private static final String MEMBER_12_KEY_REGULARDEPOSIT = "member_12_regularDeposit";
    private static final String MEMBER_12_KEY_REGULARDEPOSIT_TO = "member_12_regularDeposit_to";
    private static final String MEMBER_12_KEY_USESVACCINE = "member_12_usesVaccine";
    private static final String MEMBER_12_KEY_SOCIALINVOLVEMENTS = "member_12_socialInvolvements";
    private static final String MEMBER_12_KEY_HASRECEIVEDTRAINING = "member_12_hasReceivedTraining";
    private static final String MEMBER_12_KEY_TRAININGLIST = "member_12_trainingList";
    private static final String MEMBER_12_KEY_TRAVELWORK = "member_12_travelWork";
    private static final String MEMBER_12_KEY_TRAVELWORKTO = "member_12_travelWorkTo";
    private static final String MEMBER_12_KEY_TRAVELBUSINESS = "member_12_travelBusiness";
    private static final String MEMBER_12_KEY_TRAVELBUSINESSTO = "member_12_travelBusinessTo";
    private static final String MEMBER_12_KEY_TRAVELEDUCATION = "member_12_travelEducation";
    private static final String MEMBER_12_KEY_TRAVELEDUCATIONTO = "member_12_travelEducationTo";
    private static final String MEMBER_12_KEY_TRAVELOTHERS = "member_12_travelOthers";
    private static final String MEMBER_12_KEY_TRAVELOTHERSTO = "member_12_travelOthersTo";

    private static final String MEMBER_13_KEY_NAME_THAR = "member_13_name_thar";
    private static final String MEMBER_13_KEY_GENDER = "member_13_gender";
    private static final String MEMBER_13_KEY_AGE = "member_13_age";
    private static final String MEMBER_13_KEY_RELATION_TO_OWNER = "member_13_relation_to_owner";
    private static final String MEMBER_13_KEY_LEAVE_HOME_6MONTH = "member_13_leave_home_6month";
    private static final String MEMBER_13_KEY_LEAVE_HOME_REASON = "member_13_leave_home_reason";
    private static final String MEMBER_13_KEY_EDUCATION = "member_13_education";
    private static final String MEMBER_13_KEY_SCHOOL_TYPE = "member_13_school_type";
    private static final String MEMBER_13_KEY_LEAVE_SCHOOL_REASON = "member_13_leave_school_reason";
    private static final String MEMBER_13_KEY_INCOME_SOURCE = "member_13_income_source";
    private static final String MEMBER_13_KEY_ABROAD_COUNTRY = "member_13_abroad_country";
    private static final String MEMBER_13_KEY_ABROAD_MONEYTRANSFER = "member_13_abroad_moneyTransfer";
    private static final String MEMBER_13_KEY_SKILLS = "member_13_skills";
    private static final String MEMBER_13_KEY_REGULARDEPOSIT = "member_13_regularDeposit";
    private static final String MEMBER_13_KEY_REGULARDEPOSIT_TO = "member_13_regularDeposit_to";
    private static final String MEMBER_13_KEY_USESVACCINE = "member_13_usesVaccine";
    private static final String MEMBER_13_KEY_SOCIALINVOLVEMENTS = "member_13_socialInvolvements";
    private static final String MEMBER_13_KEY_HASRECEIVEDTRAINING = "member_13_hasReceivedTraining";
    private static final String MEMBER_13_KEY_TRAININGLIST = "member_13_trainingList";
    private static final String MEMBER_13_KEY_TRAVELWORK = "member_13_travelWork";
    private static final String MEMBER_13_KEY_TRAVELWORKTO = "member_13_travelWorkTo";
    private static final String MEMBER_13_KEY_TRAVELBUSINESS = "member_13_travelBusiness";
    private static final String MEMBER_13_KEY_TRAVELBUSINESSTO = "member_13_travelBusinessTo";
    private static final String MEMBER_13_KEY_TRAVELEDUCATION = "member_13_travelEducation";
    private static final String MEMBER_13_KEY_TRAVELEDUCATIONTO = "member_13_travelEducationTo";
    private static final String MEMBER_13_KEY_TRAVELOTHERS = "member_13_travelOthers";
    private static final String MEMBER_13_KEY_TRAVELOTHERSTO = "member_13_travelOthersTo";


    private static final String MEMBER_14_KEY_NAME_THAR = "member_14_name_thar";
    private static final String MEMBER_14_KEY_GENDER = "member_14_gender";
    private static final String MEMBER_14_KEY_AGE = "member_14_age";
    private static final String MEMBER_14_KEY_RELATION_TO_OWNER = "member_14_relation_to_owner";
    private static final String MEMBER_14_KEY_LEAVE_HOME_6MONTH = "member_14_leave_home_6month";
    private static final String MEMBER_14_KEY_LEAVE_HOME_REASON = "member_14_leave_home_reason";
    private static final String MEMBER_14_KEY_EDUCATION = "member_14_education";
    private static final String MEMBER_14_KEY_SCHOOL_TYPE = "member_14_school_type";
    private static final String MEMBER_14_KEY_LEAVE_SCHOOL_REASON = "member_14_leave_school_reason";
    private static final String MEMBER_14_KEY_INCOME_SOURCE = "member_14_income_source";
    private static final String MEMBER_14_KEY_ABROAD_COUNTRY = "member_14_abroad_country";
    private static final String MEMBER_14_KEY_ABROAD_MONEYTRANSFER = "member_14_abroad_moneyTransfer";
    private static final String MEMBER_14_KEY_SKILLS = "member_14_skills";
    private static final String MEMBER_14_KEY_REGULARDEPOSIT = "member_14_regularDeposit";
    private static final String MEMBER_14_KEY_REGULARDEPOSIT_TO = "member_14_regularDeposit_to";
    private static final String MEMBER_14_KEY_USESVACCINE = "member_14_usesVaccine";
    private static final String MEMBER_14_KEY_SOCIALINVOLVEMENTS = "member_14_socialInvolvements";
    private static final String MEMBER_14_KEY_HASRECEIVEDTRAINING = "member_14_hasReceivedTraining";
    private static final String MEMBER_14_KEY_TRAININGLIST = "member_14_trainingList";
    private static final String MEMBER_14_KEY_TRAVELWORK = "member_14_travelWork";
    private static final String MEMBER_14_KEY_TRAVELWORKTO = "member_14_travelWorkTo";
    private static final String MEMBER_14_KEY_TRAVELBUSINESS = "member_14_travelBusiness";
    private static final String MEMBER_14_KEY_TRAVELBUSINESSTO = "member_14_travelBusinessTo";
    private static final String MEMBER_14_KEY_TRAVELEDUCATION = "member_14_travelEducation";
    private static final String MEMBER_14_KEY_TRAVELEDUCATIONTO = "member_14_travelEducationTo";
    private static final String MEMBER_14_KEY_TRAVELOTHERS = "member_14_travelOthers";
    private static final String MEMBER_14_KEY_TRAVELOTHERSTO = "member_14_travelOthersTo";

    private static final String MEMBER_15_KEY_NAME_THAR = "member_15_name_thar";
    private static final String MEMBER_15_KEY_GENDER = "member_15_gender";
    private static final String MEMBER_15_KEY_AGE = "member_15_age";
    private static final String MEMBER_15_KEY_RELATION_TO_OWNER = "member_15_relation_to_owner";
    private static final String MEMBER_15_KEY_LEAVE_HOME_6MONTH = "member_15_leave_home_6month";
    private static final String MEMBER_15_KEY_LEAVE_HOME_REASON = "member_15_leave_home_reason";
    private static final String MEMBER_15_KEY_EDUCATION = "member_15_education";
    private static final String MEMBER_15_KEY_SCHOOL_TYPE = "member_15_school_type";
    private static final String MEMBER_15_KEY_LEAVE_SCHOOL_REASON = "member_15_leave_school_reason";
    private static final String MEMBER_15_KEY_INCOME_SOURCE = "member_15_income_source";
    private static final String MEMBER_15_KEY_ABROAD_COUNTRY = "member_15_abroad_country";
    private static final String MEMBER_15_KEY_ABROAD_MONEYTRANSFER = "member_15_abroad_moneyTransfer";
    private static final String MEMBER_15_KEY_SKILLS = "member_15_skills";
    private static final String MEMBER_15_KEY_REGULARDEPOSIT = "member_15_regularDeposit";
    private static final String MEMBER_15_KEY_REGULARDEPOSIT_TO = "member_15_regularDeposit_to";
    private static final String MEMBER_15_KEY_USESVACCINE = "member_15_usesVaccine";
    private static final String MEMBER_15_KEY_SOCIALINVOLVEMENTS = "member_15_socialInvolvements";
    private static final String MEMBER_15_KEY_HASRECEIVEDTRAINING = "member_15_hasReceivedTraining";
    private static final String MEMBER_15_KEY_TRAININGLIST = "member_15_trainingList";
    private static final String MEMBER_15_KEY_TRAVELWORK = "member_15_travelWork";
    private static final String MEMBER_15_KEY_TRAVELWORKTO = "member_15_travelWorkTo";
    private static final String MEMBER_15_KEY_TRAVELBUSINESS = "member_15_travelBusiness";
    private static final String MEMBER_15_KEY_TRAVELBUSINESSTO = "member_15_travelBusinessTo";
    private static final String MEMBER_15_KEY_TRAVELEDUCATION = "member_15_travelEducation";
    private static final String MEMBER_15_KEY_TRAVELEDUCATIONTO = "member_15_travelEducationTo";
    private static final String MEMBER_15_KEY_TRAVELOTHERS = "member_15_travelOthers";
    private static final String MEMBER_15_KEY_TRAVELOTHERSTO = "member_15_travelOthersTo";

    private static final String MEMBER_16_KEY_NAME_THAR = "member_16_name_thar";
    private static final String MEMBER_16_KEY_GENDER = "member_16_gender";
    private static final String MEMBER_16_KEY_AGE = "member_16_age";
    private static final String MEMBER_16_KEY_RELATION_TO_OWNER = "member_16_relation_to_owner";
    private static final String MEMBER_16_KEY_LEAVE_HOME_6MONTH = "member_16_leave_home_6month";
    private static final String MEMBER_16_KEY_LEAVE_HOME_REASON = "member_16_leave_home_reason";
    private static final String MEMBER_16_KEY_EDUCATION = "member_16_education";
    private static final String MEMBER_16_KEY_SCHOOL_TYPE = "member_16_school_type";
    private static final String MEMBER_16_KEY_LEAVE_SCHOOL_REASON = "member_16_leave_school_reason";
    private static final String MEMBER_16_KEY_INCOME_SOURCE = "member_16_income_source";
    private static final String MEMBER_16_KEY_ABROAD_COUNTRY = "member_16_abroad_country";
    private static final String MEMBER_16_KEY_ABROAD_MONEYTRANSFER = "member_16_abroad_moneyTransfer";
    private static final String MEMBER_16_KEY_SKILLS = "member_16_skills";
    private static final String MEMBER_16_KEY_REGULARDEPOSIT = "member_16_regularDeposit";
    private static final String MEMBER_16_KEY_REGULARDEPOSIT_TO = "member_16_regularDeposit_to";
    private static final String MEMBER_16_KEY_USESVACCINE = "member_16_usesVaccine";
    private static final String MEMBER_16_KEY_SOCIALINVOLVEMENTS = "member_16_socialInvolvements";
    private static final String MEMBER_16_KEY_HASRECEIVEDTRAINING = "member_16_hasReceivedTraining";
    private static final String MEMBER_16_KEY_TRAININGLIST = "member_16_trainingList";
    private static final String MEMBER_16_KEY_TRAVELWORK = "member_16_travelWork";
    private static final String MEMBER_16_KEY_TRAVELWORKTO = "member_16_travelWorkTo";
    private static final String MEMBER_16_KEY_TRAVELBUSINESS = "member_16_travelBusiness";
    private static final String MEMBER_16_KEY_TRAVELBUSINESSTO = "member_16_travelBusinessTo";
    private static final String MEMBER_16_KEY_TRAVELEDUCATION = "member_16_travelEducation";
    private static final String MEMBER_16_KEY_TRAVELEDUCATIONTO = "member_16_travelEducationTo";
    private static final String MEMBER_16_KEY_TRAVELOTHERS = "member_16_travelOthers";
    private static final String MEMBER_16_KEY_TRAVELOTHERSTO = "member_16_travelOthersTo";

    private static final String MEMBER_17_KEY_NAME_THAR = "member_17_name_thar";
    private static final String MEMBER_17_KEY_GENDER = "member_17_gender";
    private static final String MEMBER_17_KEY_AGE = "member_17_age";
    private static final String MEMBER_17_KEY_RELATION_TO_OWNER = "member_17_relation_to_owner";
    private static final String MEMBER_17_KEY_LEAVE_HOME_6MONTH = "member_17_leave_home_6month";
    private static final String MEMBER_17_KEY_LEAVE_HOME_REASON = "member_17_leave_home_reason";
    private static final String MEMBER_17_KEY_EDUCATION = "member_17_education";
    private static final String MEMBER_17_KEY_SCHOOL_TYPE = "member_17_school_type";
    private static final String MEMBER_17_KEY_LEAVE_SCHOOL_REASON = "member_17_leave_school_reason";
    private static final String MEMBER_17_KEY_INCOME_SOURCE = "member_17_income_source";
    private static final String MEMBER_17_KEY_ABROAD_COUNTRY = "member_17_abroad_country";
    private static final String MEMBER_17_KEY_ABROAD_MONEYTRANSFER = "member_17_abroad_moneyTransfer";
    private static final String MEMBER_17_KEY_SKILLS = "member_17_skills";
    private static final String MEMBER_17_KEY_REGULARDEPOSIT = "member_17_regularDeposit";
    private static final String MEMBER_17_KEY_REGULARDEPOSIT_TO = "member_17_regularDeposit_to";
    private static final String MEMBER_17_KEY_USESVACCINE = "member_17_usesVaccine";
    private static final String MEMBER_17_KEY_SOCIALINVOLVEMENTS = "member_17_socialInvolvements";
    private static final String MEMBER_17_KEY_HASRECEIVEDTRAINING = "member_17_hasReceivedTraining";
    private static final String MEMBER_17_KEY_TRAININGLIST = "member_17_trainingList";
    private static final String MEMBER_17_KEY_TRAVELWORK = "member_17_travelWork";
    private static final String MEMBER_17_KEY_TRAVELWORKTO = "member_17_travelWorkTo";
    private static final String MEMBER_17_KEY_TRAVELBUSINESS = "member_17_travelBusiness";
    private static final String MEMBER_17_KEY_TRAVELBUSINESSTO = "member_17_travelBusinessTo";
    private static final String MEMBER_17_KEY_TRAVELEDUCATION = "member_17_travelEducation";
    private static final String MEMBER_17_KEY_TRAVELEDUCATIONTO = "member_17_travelEducationTo";
    private static final String MEMBER_17_KEY_TRAVELOTHERS = "member_17_travelOthers";
    private static final String MEMBER_17_KEY_TRAVELOTHERSTO = "member_17_travelOthersTo";

    private static final String MEMBER_18_KEY_NAME_THAR = "member_18_name_thar";
    private static final String MEMBER_18_KEY_GENDER = "member_18_gender";
    private static final String MEMBER_18_KEY_AGE = "member_18_age";
    private static final String MEMBER_18_KEY_RELATION_TO_OWNER = "member_18_relation_to_owner";
    private static final String MEMBER_18_KEY_LEAVE_HOME_6MONTH = "member_18_leave_home_6month";
    private static final String MEMBER_18_KEY_LEAVE_HOME_REASON = "member_18_leave_home_reason";
    private static final String MEMBER_18_KEY_EDUCATION = "member_18_education";
    private static final String MEMBER_18_KEY_SCHOOL_TYPE = "member_18_school_type";
    private static final String MEMBER_18_KEY_LEAVE_SCHOOL_REASON = "member_18_leave_school_reason";
    private static final String MEMBER_18_KEY_INCOME_SOURCE = "member_18_income_source";
    private static final String MEMBER_18_KEY_ABROAD_COUNTRY = "member_18_abroad_country";
    private static final String MEMBER_18_KEY_ABROAD_MONEYTRANSFER = "member_18_abroad_moneyTransfer";
    private static final String MEMBER_18_KEY_SKILLS = "member_18_skills";
    private static final String MEMBER_18_KEY_REGULARDEPOSIT = "member_18_regularDeposit";
    private static final String MEMBER_18_KEY_REGULARDEPOSIT_TO = "member_18_regularDeposit_to";
    private static final String MEMBER_18_KEY_USESVACCINE = "member_18_usesVaccine";
    private static final String MEMBER_18_KEY_SOCIALINVOLVEMENTS = "member_18_socialInvolvements";
    private static final String MEMBER_18_KEY_HASRECEIVEDTRAINING = "member_18_hasReceivedTraining";
    private static final String MEMBER_18_KEY_TRAININGLIST = "member_18_trainingList";
    private static final String MEMBER_18_KEY_TRAVELWORK = "member_18_travelWork";
    private static final String MEMBER_18_KEY_TRAVELWORKTO = "member_18_travelWorkTo";
    private static final String MEMBER_18_KEY_TRAVELBUSINESS = "member_18_travelBusiness";
    private static final String MEMBER_18_KEY_TRAVELBUSINESSTO = "member_18_travelBusinessTo";
    private static final String MEMBER_18_KEY_TRAVELEDUCATION = "member_18_travelEducation";
    private static final String MEMBER_18_KEY_TRAVELEDUCATIONTO = "member_18_travelEducationTo";
    private static final String MEMBER_18_KEY_TRAVELOTHERS = "member_18_travelOthers";
    private static final String MEMBER_18_KEY_TRAVELOTHERSTO = "member_18_travelOthersTo";

    private static final String MEMBER_19_KEY_NAME_THAR = "member_19_name_thar";
    private static final String MEMBER_19_KEY_GENDER = "member_19_gender";
    private static final String MEMBER_19_KEY_AGE = "member_19_age";
    private static final String MEMBER_19_KEY_RELATION_TO_OWNER = "member_19_relation_to_owner";
    private static final String MEMBER_19_KEY_LEAVE_HOME_6MONTH = "member_19_leave_home_6month";
    private static final String MEMBER_19_KEY_LEAVE_HOME_REASON = "member_19_leave_home_reason";
    private static final String MEMBER_19_KEY_EDUCATION = "member_19_education";
    private static final String MEMBER_19_KEY_SCHOOL_TYPE = "member_19_school_type";
    private static final String MEMBER_19_KEY_LEAVE_SCHOOL_REASON = "member_19_leave_school_reason";
    private static final String MEMBER_19_KEY_INCOME_SOURCE = "member_19_income_source";
    private static final String MEMBER_19_KEY_ABROAD_COUNTRY = "member_19_abroad_country";
    private static final String MEMBER_19_KEY_ABROAD_MONEYTRANSFER = "member_19_abroad_moneyTransfer";
    private static final String MEMBER_19_KEY_SKILLS = "member_19_skills";
    private static final String MEMBER_19_KEY_REGULARDEPOSIT = "member_19_regularDeposit";
    private static final String MEMBER_19_KEY_REGULARDEPOSIT_TO = "member_19_regularDeposit_to";
    private static final String MEMBER_19_KEY_USESVACCINE = "member_19_usesVaccine";
    private static final String MEMBER_19_KEY_SOCIALINVOLVEMENTS = "member_19_socialInvolvements";
    private static final String MEMBER_19_KEY_HASRECEIVEDTRAINING = "member_19_hasReceivedTraining";
    private static final String MEMBER_19_KEY_TRAININGLIST = "member_19_trainingList";
    private static final String MEMBER_19_KEY_TRAVELWORK = "member_19_travelWork";
    private static final String MEMBER_19_KEY_TRAVELWORKTO = "member_19_travelWorkTo";
    private static final String MEMBER_19_KEY_TRAVELBUSINESS = "member_19_travelBusiness";
    private static final String MEMBER_19_KEY_TRAVELBUSINESSTO = "member_19_travelBusinessTo";
    private static final String MEMBER_19_KEY_TRAVELEDUCATION = "member_19_travelEducation";
    private static final String MEMBER_19_KEY_TRAVELEDUCATIONTO = "member_19_travelEducationTo";
    private static final String MEMBER_19_KEY_TRAVELOTHERS = "member_19_travelOthers";
    private static final String MEMBER_19_KEY_TRAVELOTHERSTO = "member_19_travelOthersTo";

    private static final String MEMBER_20_KEY_NAME_THAR = "member_20_name_thar";
    private static final String MEMBER_20_KEY_GENDER = "member_20_gender";
    private static final String MEMBER_20_KEY_AGE = "member_20_age";
    private static final String MEMBER_20_KEY_RELATION_TO_OWNER = "member_20_relation_to_owner";
    private static final String MEMBER_20_KEY_LEAVE_HOME_6MONTH = "member_20_leave_home_6month";
    private static final String MEMBER_20_KEY_LEAVE_HOME_REASON = "member_20_leave_home_reason";
    private static final String MEMBER_20_KEY_EDUCATION = "member_20_education";
    private static final String MEMBER_20_KEY_SCHOOL_TYPE = "member_20_school_type";
    private static final String MEMBER_20_KEY_LEAVE_SCHOOL_REASON = "member_20_leave_school_reason";
    private static final String MEMBER_20_KEY_INCOME_SOURCE = "member_20_income_source";
    private static final String MEMBER_20_KEY_ABROAD_COUNTRY = "member_20_abroad_country";
    private static final String MEMBER_20_KEY_ABROAD_MONEYTRANSFER = "member_20_abroad_moneyTransfer";
    private static final String MEMBER_20_KEY_SKILLS = "member_20_skills";
    private static final String MEMBER_20_KEY_REGULARDEPOSIT = "member_20_regularDeposit";
    private static final String MEMBER_20_KEY_REGULARDEPOSIT_TO = "member_20_regularDeposit_to";
    private static final String MEMBER_20_KEY_USESVACCINE = "member_20_usesVaccine";
    private static final String MEMBER_20_KEY_SOCIALINVOLVEMENTS = "member_20_socialInvolvements";
    private static final String MEMBER_20_KEY_HASRECEIVEDTRAINING = "member_20_hasReceivedTraining";
    private static final String MEMBER_20_KEY_TRAININGLIST = "member_20_trainingList";
    private static final String MEMBER_20_KEY_TRAVELWORK = "member_20_travelWork";
    private static final String MEMBER_20_KEY_TRAVELWORKTO = "member_20_travelWorkTo";
    private static final String MEMBER_20_KEY_TRAVELBUSINESS = "member_20_travelBusiness";
    private static final String MEMBER_20_KEY_TRAVELBUSINESSTO = "member_20_travelBusinessTo";
    private static final String MEMBER_20_KEY_TRAVELEDUCATION = "member_20_travelEducation";
    private static final String MEMBER_20_KEY_TRAVELEDUCATIONTO = "member_20_travelEducationTo";
    private static final String MEMBER_20_KEY_TRAVELOTHERS = "member_20_travelOthers";
    private static final String MEMBER_20_KEY_TRAVELOTHERSTO = "member_20_travelOthersTo";

    private static final String MEMBER_21_KEY_NAME_THAR = "member_21_name_thar";
    private static final String MEMBER_21_KEY_GENDER = "member_21_gender";
    private static final String MEMBER_21_KEY_AGE = "member_21_age";
    private static final String MEMBER_21_KEY_RELATION_TO_OWNER = "member_21_relation_to_owner";
    private static final String MEMBER_21_KEY_LEAVE_HOME_6MONTH = "member_21_leave_home_6month";
    private static final String MEMBER_21_KEY_LEAVE_HOME_REASON = "member_21_leave_home_reason";
    private static final String MEMBER_21_KEY_EDUCATION = "member_21_education";
    private static final String MEMBER_21_KEY_SCHOOL_TYPE = "member_21_school_type";
    private static final String MEMBER_21_KEY_LEAVE_SCHOOL_REASON = "member_21_leave_school_reason";
    private static final String MEMBER_21_KEY_INCOME_SOURCE = "member_21_income_source";
    private static final String MEMBER_21_KEY_ABROAD_COUNTRY = "member_21_abroad_country";
    private static final String MEMBER_21_KEY_ABROAD_MONEYTRANSFER = "member_21_abroad_moneyTransfer";
    private static final String MEMBER_21_KEY_SKILLS = "member_21_skills";
    private static final String MEMBER_21_KEY_REGULARDEPOSIT = "member_21_regularDeposit";
    private static final String MEMBER_21_KEY_REGULARDEPOSIT_TO = "member_21_regularDeposit_to";
    private static final String MEMBER_21_KEY_USESVACCINE = "member_21_usesVaccine";
    private static final String MEMBER_21_KEY_SOCIALINVOLVEMENTS = "member_21_socialInvolvements";
    private static final String MEMBER_21_KEY_HASRECEIVEDTRAINING = "member_21_hasReceivedTraining";
    private static final String MEMBER_21_KEY_TRAININGLIST = "member_21_trainingList";
    private static final String MEMBER_21_KEY_TRAVELWORK = "member_21_travelWork";
    private static final String MEMBER_21_KEY_TRAVELWORKTO = "member_21_travelWorkTo";
    private static final String MEMBER_21_KEY_TRAVELBUSINESS = "member_21_travelBusiness";
    private static final String MEMBER_21_KEY_TRAVELBUSINESSTO = "member_21_travelBusinessTo";
    private static final String MEMBER_21_KEY_TRAVELEDUCATION = "member_21_travelEducation";
    private static final String MEMBER_21_KEY_TRAVELEDUCATIONTO = "member_21_travelEducationTo";
    private static final String MEMBER_21_KEY_TRAVELOTHERS = "member_21_travelOthers";
    private static final String MEMBER_21_KEY_TRAVELOTHERSTO = "member_21_travelOthersTo";

    private static final String MEMBER_22_KEY_NAME_THAR = "member_22_name_thar";
    private static final String MEMBER_22_KEY_GENDER = "member_22_gender";
    private static final String MEMBER_22_KEY_AGE = "member_22_age";
    private static final String MEMBER_22_KEY_RELATION_TO_OWNER = "member_22_relation_to_owner";
    private static final String MEMBER_22_KEY_LEAVE_HOME_6MONTH = "member_22_leave_home_6month";
    private static final String MEMBER_22_KEY_LEAVE_HOME_REASON = "member_22_leave_home_reason";
    private static final String MEMBER_22_KEY_EDUCATION = "member_22_education";
    private static final String MEMBER_22_KEY_SCHOOL_TYPE = "member_22_school_type";
    private static final String MEMBER_22_KEY_LEAVE_SCHOOL_REASON = "member_22_leave_school_reason";
    private static final String MEMBER_22_KEY_INCOME_SOURCE = "member_22_income_source";
    private static final String MEMBER_22_KEY_ABROAD_COUNTRY = "member_22_abroad_country";
    private static final String MEMBER_22_KEY_ABROAD_MONEYTRANSFER = "member_22_abroad_moneyTransfer";
    private static final String MEMBER_22_KEY_SKILLS = "member_22_skills";
    private static final String MEMBER_22_KEY_REGULARDEPOSIT = "member_22_regularDeposit";
    private static final String MEMBER_22_KEY_REGULARDEPOSIT_TO = "member_22_regularDeposit_to";
    private static final String MEMBER_22_KEY_USESVACCINE = "member_22_usesVaccine";
    private static final String MEMBER_22_KEY_SOCIALINVOLVEMENTS = "member_22_socialInvolvements";
    private static final String MEMBER_22_KEY_HASRECEIVEDTRAINING = "member_22_hasReceivedTraining";
    private static final String MEMBER_22_KEY_TRAININGLIST = "member_22_trainingList";
    private static final String MEMBER_22_KEY_TRAVELWORK = "member_22_travelWork";
    private static final String MEMBER_22_KEY_TRAVELWORKTO = "member_22_travelWorkTo";
    private static final String MEMBER_22_KEY_TRAVELBUSINESS = "member_22_travelBusiness";
    private static final String MEMBER_22_KEY_TRAVELBUSINESSTO = "member_22_travelBusinessTo";
    private static final String MEMBER_22_KEY_TRAVELEDUCATION = "member_22_travelEducation";
    private static final String MEMBER_22_KEY_TRAVELEDUCATIONTO = "member_22_travelEducationTo";
    private static final String MEMBER_22_KEY_TRAVELOTHERS = "member_22_travelOthers";
    private static final String MEMBER_22_KEY_TRAVELOTHERSTO = "member_22_travelOthersTo";

    private static final String MEMBER_23_KEY_NAME_THAR = "member_23_name_thar";
    private static final String MEMBER_23_KEY_GENDER = "member_23_gender";
    private static final String MEMBER_23_KEY_AGE = "member_23_age";
    private static final String MEMBER_23_KEY_RELATION_TO_OWNER = "member_23_relation_to_owner";
    private static final String MEMBER_23_KEY_LEAVE_HOME_6MONTH = "member_23_leave_home_6month";
    private static final String MEMBER_23_KEY_LEAVE_HOME_REASON = "member_23_leave_home_reason";
    private static final String MEMBER_23_KEY_EDUCATION = "member_23_education";
    private static final String MEMBER_23_KEY_SCHOOL_TYPE = "member_23_school_type";
    private static final String MEMBER_23_KEY_LEAVE_SCHOOL_REASON = "member_23_leave_school_reason";
    private static final String MEMBER_23_KEY_INCOME_SOURCE = "member_23_income_source";
    private static final String MEMBER_23_KEY_ABROAD_COUNTRY = "member_23_abroad_country";
    private static final String MEMBER_23_KEY_ABROAD_MONEYTRANSFER = "member_23_abroad_moneyTransfer";
    private static final String MEMBER_23_KEY_SKILLS = "member_23_skills";
    private static final String MEMBER_23_KEY_REGULARDEPOSIT = "member_23_regularDeposit";
    private static final String MEMBER_23_KEY_REGULARDEPOSIT_TO = "member_23_regularDeposit_to";
    private static final String MEMBER_23_KEY_USESVACCINE = "member_23_usesVaccine";
    private static final String MEMBER_23_KEY_SOCIALINVOLVEMENTS = "member_23_socialInvolvements";
    private static final String MEMBER_23_KEY_HASRECEIVEDTRAINING = "member_23_hasReceivedTraining";
    private static final String MEMBER_23_KEY_TRAININGLIST = "member_23_trainingList";
    private static final String MEMBER_23_KEY_TRAVELWORK = "member_23_travelWork";
    private static final String MEMBER_23_KEY_TRAVELWORKTO = "member_23_travelWorkTo";
    private static final String MEMBER_23_KEY_TRAVELBUSINESS = "member_23_travelBusiness";
    private static final String MEMBER_23_KEY_TRAVELBUSINESSTO = "member_23_travelBusinessTo";
    private static final String MEMBER_23_KEY_TRAVELEDUCATION = "member_23_travelEducation";
    private static final String MEMBER_23_KEY_TRAVELEDUCATIONTO = "member_23_travelEducationTo";
    private static final String MEMBER_23_KEY_TRAVELOTHERS = "member_23_travelOthers";
    private static final String MEMBER_23_KEY_TRAVELOTHERSTO = "member_23_travelOthersTo";

    private static final String MEMBER_24_KEY_NAME_THAR = "member_24_name_thar";
    private static final String MEMBER_24_KEY_GENDER = "member_24_gender";
    private static final String MEMBER_24_KEY_AGE = "member_24_age";
    private static final String MEMBER_24_KEY_RELATION_TO_OWNER = "member_24_relation_to_owner";
    private static final String MEMBER_24_KEY_LEAVE_HOME_6MONTH = "member_24_leave_home_6month";
    private static final String MEMBER_24_KEY_LEAVE_HOME_REASON = "member_24_leave_home_reason";
    private static final String MEMBER_24_KEY_EDUCATION = "member_24_education";
    private static final String MEMBER_24_KEY_SCHOOL_TYPE = "member_24_school_type";
    private static final String MEMBER_24_KEY_LEAVE_SCHOOL_REASON = "member_24_leave_school_reason";
    private static final String MEMBER_24_KEY_INCOME_SOURCE = "member_24_income_source";
    private static final String MEMBER_24_KEY_ABROAD_COUNTRY = "member_24_abroad_country";
    private static final String MEMBER_24_KEY_ABROAD_MONEYTRANSFER = "member_24_abroad_moneyTransfer";
    private static final String MEMBER_24_KEY_SKILLS = "member_24_skills";
    private static final String MEMBER_24_KEY_REGULARDEPOSIT = "member_24_regularDeposit";
    private static final String MEMBER_24_KEY_REGULARDEPOSIT_TO = "member_24_regularDeposit_to";
    private static final String MEMBER_24_KEY_USESVACCINE = "member_24_usesVaccine";
    private static final String MEMBER_24_KEY_SOCIALINVOLVEMENTS = "member_24_socialInvolvements";
    private static final String MEMBER_24_KEY_HASRECEIVEDTRAINING = "member_24_hasReceivedTraining";
    private static final String MEMBER_24_KEY_TRAININGLIST = "member_24_trainingList";
    private static final String MEMBER_24_KEY_TRAVELWORK = "member_24_travelWork";
    private static final String MEMBER_24_KEY_TRAVELWORKTO = "member_24_travelWorkTo";
    private static final String MEMBER_24_KEY_TRAVELBUSINESS = "member_24_travelBusiness";
    private static final String MEMBER_24_KEY_TRAVELBUSINESSTO = "member_24_travelBusinessTo";
    private static final String MEMBER_24_KEY_TRAVELEDUCATION = "member_24_travelEducation";
    private static final String MEMBER_24_KEY_TRAVELEDUCATIONTO = "member_24_travelEducationTo";
    private static final String MEMBER_24_KEY_TRAVELOTHERS = "member_24_travelOthers";
    private static final String MEMBER_24_KEY_TRAVELOTHERSTO = "member_24_travelOthersTo";

    private static final String MEMBER_25_KEY_NAME_THAR = "member_25_name_thar";
    private static final String MEMBER_25_KEY_GENDER = "member_25_gender";
    private static final String MEMBER_25_KEY_AGE = "member_25_age";
    private static final String MEMBER_25_KEY_RELATION_TO_OWNER = "member_25_relation_to_owner";
    private static final String MEMBER_25_KEY_LEAVE_HOME_6MONTH = "member_25_leave_home_6month";
    private static final String MEMBER_25_KEY_LEAVE_HOME_REASON = "member_25_leave_home_reason";
    private static final String MEMBER_25_KEY_EDUCATION = "member_25_education";
    private static final String MEMBER_25_KEY_SCHOOL_TYPE = "member_25_school_type";
    private static final String MEMBER_25_KEY_LEAVE_SCHOOL_REASON = "member_25_leave_school_reason";
    private static final String MEMBER_25_KEY_INCOME_SOURCE = "member_25_income_source";
    private static final String MEMBER_25_KEY_ABROAD_COUNTRY = "member_25_abroad_country";
    private static final String MEMBER_25_KEY_ABROAD_MONEYTRANSFER = "member_25_abroad_moneyTransfer";
    private static final String MEMBER_25_KEY_SKILLS = "member_25_skills";
    private static final String MEMBER_25_KEY_REGULARDEPOSIT = "member_25_regularDeposit";
    private static final String MEMBER_25_KEY_REGULARDEPOSIT_TO = "member_25_regularDeposit_to";
    private static final String MEMBER_25_KEY_USESVACCINE = "member_25_usesVaccine";
    private static final String MEMBER_25_KEY_SOCIALINVOLVEMENTS = "member_25_socialInvolvements";
    private static final String MEMBER_25_KEY_HASRECEIVEDTRAINING = "member_25_hasReceivedTraining";
    private static final String MEMBER_25_KEY_TRAININGLIST = "member_25_trainingList";
    private static final String MEMBER_25_KEY_TRAVELWORK = "member_25_travelWork";
    private static final String MEMBER_25_KEY_TRAVELWORKTO = "member_25_travelWorkTo";
    private static final String MEMBER_25_KEY_TRAVELBUSINESS = "member_25_travelBusiness";
    private static final String MEMBER_25_KEY_TRAVELBUSINESSTO = "member_25_travelBusinessTo";
    private static final String MEMBER_25_KEY_TRAVELEDUCATION = "member_25_travelEducation";
    private static final String MEMBER_25_KEY_TRAVELEDUCATIONTO = "member_25_travelEducationTo";
    private static final String MEMBER_25_KEY_TRAVELOTHERS = "member_25_travelOthers";
    private static final String MEMBER_25_KEY_TRAVELOTHERSTO = "member_25_travelOthersTo";

    // Individual Data

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("

                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_LAT + " TEXT,"
                + KEY_LNG + " TEXT,"
                + KEY_ALT + " TEXT,"
                + KEY_HOUSE_CODE + " TEXT,"
                + KEY_PRADESH + " TEXT,"
                + KEY_JILLA + " TEXT,"
                + KEY_NAGARPALIKA + " TEXT,"
                + KEY_WARD + " TEXT,"
                + KEY_BASTI + " TEXT,"
                + KEY_TOLENAME + " TEXT,"
                + KEY_SADAKNAME + " TEXT,"
                + KEY_GHARDHANINAME + " TEXT,"
                + KEY_GHARDHANISEX + " TEXT,"
                + KEY_GHARDHANIPHONE + " TEXT,"

                + KEY_TENANT_FAMILY_COUNT + " TEXT,"
                + KEY_HOME_BUSINESS + " TEXT,"
                + KEY_INFORMER_NAME + " TEXT,"
                + KEY_INFORMER_GENDER + " TEXT,"
                + KEY_INFORMER_AGE + " TEXT,"
                + KEY_INFORMER_EMAIL + " TEXT,"
                + KEY_SWAMITTO + " TEXT,"
                + KEY_BASAI_ABADHI + " TEXT,"
                + KEY_JATIYA_SAMUHA + " TEXT,"
                + KEY_JATJATI + " TEXT,"
                + KEY_DHARMA + " TEXT,"
                + KEY_MATRIBHASHA + " TEXT,"

                + KEY_PARIWAR_BASOBAS_AVASTHA + " TEXT,"
                + KEY_KUN_STHAN_BATA_BASAI_SAREKO + " TEXT,"
                + KEY_BASAI_SARNU_KARAN + " TEXT,"
                + KEY_BASAI_AVADHI + " TEXT,"
                + KEY_NAGARPALIKA_MA_GHAR_BHAYEKO + " TEXT,"
                + KEY_GHAR_JAGGA_SWAMITTO_KISIM + " TEXT,"
                + KEY_JAGGA_KO_AREA + " TEXT,"
                + KEY_SICHAI_JAGGA_KO_AREA + " TEXT,"
                + KEY_NAGARPALIKA_MA_ANYA_GHAR_BHAYEKO + " TEXT,"
                + KEY_ANYA_GHAR_K_KO_LAGI + " TEXT,"

                + KEY_OWNSLAND + " TEXT,"
                + KEY_LANDLOCATION + " TEXT,"
                + KEY_LANDOWNEDBY + " TEXT,"
                + KEY_LANDUSEDAS + " TEXT,"
                + KEY_LANDONLEASE + " TEXT,"
                + KEY_LANDONLEASEUSEDAS + " TEXT,"

                + KEY_GHAR_KO_PRAKAR + " TEXT,"
                + KEY_GHAR_EARTHQUAKE_PROOF + " TEXT,"
                + KEY_GHAR_ROOF_TYPE + " TEXT,"
                + KEY_KITCHEN_ALAGGAI_BHAYEKO + " TEXT,"
                + KEY_KARESOBARI_BHAYEKO + " TEXT,"
                + KEY_GHAR_NIRMAN_AVASTHA + " TEXT,"
                + KEY_GHAR_NIRMAN_BARSA + " TEXT,"
                + KEY_BATTI_MAIN_SOURCE + " TEXT,"
                + KEY_ELECTRICITY_JADAN_BHAYEKO + " TEXT,"
                + KEY_ELECTRICITY_JADAN_KINA_NABHAYEKO + " TEXT,"
                + KEY_CHULO_KO_PRAKAR + " TEXT,"
                + KEY_PAKAUNE_FUEL + " TEXT,"
                + KEY_DAAURA_KO_SOURCE + " TEXT,"
                + KEY_GAS_CYLINDER_TIKNE_DIN + " TEXT,"
                + KEY_OLD_CHULO_KO_LAGI_DAAURA_KG + " TEXT,"
                + KEY_MODERN_CHULO_KO_LAGI_DAAURA_KG + " TEXT,"
                + KEY_MATTITEL_PERMONTH_LITRE + " TEXT,"
                + KEY_INDUCTION_HEATER_HOURSPERDAY + " TEXT,"
                + KEY_OVEN_HOURSPERDAY + " TEXT,"
                + KEY_PAANI_TATAUNA_CYLINDERPERYEAR + " TEXT,"
                + KEY_PAANI_TATAUNA_WOOD_KGPERMONTH_OLD_CHULO + " TEXT,"
                + KEY_PAANI_TATAUNA_WOOD_KGPERMONTH_MODERN + " TEXT,"
                + KEY_PAANI_TATAUNA_MATTITEL_PERMONTH + " TEXT,"
                + KEY_PAANI_TATAUNA_INDUCTION_HOURSPERDAY + " TEXT,"
                + KEY_PAANI_TATAUNA_OVEN_HOURSPERDAY + " TEXT,"
                + KEY_ROOM_HEATING_UPAKARAN + " TEXT,"
                + KEY_ROOM_COOLING_UPAKARAN + " TEXT,"
                + KEY_FAN_COUNT + " TEXT,"
                + KEY_FAN_HOURSPERDAY + " TEXT,"
                + KEY_AIRCONDITION_COUNT + " TEXT,"
                + KEY_AIRCONDITION_HOURSPERDAY + " TEXT,"
                + KEY_BIJULI_UNIT + " TEXT,"
                + KEY_WASHINGMACHINE_COUNT + " TEXT,"
                + KEY_FRIDGE_COUNT + " TEXT,"
                + KEY_SOLAR_COUNT + " TEXT,"
                + KEY_VACUUM_COUNT + " TEXT,"
                + KEY_INVERTER_COUNT + " TEXT,"
                + KEY_GENERATOR_COUNT + " TEXT,"
                + KEY_DISHWASHER_COUNT + " TEXT,"
                + KEY_CABLE_COUNT + " TEXT,"
                + KEY_OTHER_HOUSE_GADGET_COUNT + " TEXT,"
                + KEY_RADIO_COUNT + " TEXT,"
                + KEY_TELEVISION_COUNT + " TEXT,"
                + KEY_TELEPHONE_COUNT + " TEXT,"
                + KEY_CELLPHONE_COUNT + " TEXT,"
                + KEY_SMARTPHONE_COUNT + " TEXT,"
                + KEY_COMPUTER_LAPTOP_COUNT + " TEXT,"
                + KEY_INTERNET_COUNT + " TEXT,"
                + KEY_OTHER_COMMUNICATION_COUNT + " TEXT,"
                + KEY_INTERNET_SPEED_MBPS + " TEXT,"
                + KEY_CYCLE_COUNT + " TEXT,"
                + KEY_BIKE_COUNT + " TEXT,"
                + KEY_LIGHTWEIGHT_VEHICLE_COUNT + " TEXT,"
                + KEY_HEAVYWEIGHT_VEHICLE_COUNT + " TEXT,"
                + KEY_PUBLIC_TRANSPORT_VEHICLE_COUNT + " TEXT,"
                + KEY_FAMILY_MA_YATAYAT_LICENSE_BHAYEKO + " TEXT,"
                + KEY_LICENSE_BHAYEKO_COUNT + " TEXT,"
                + KEY_LICENSE_COUNT_2_WHEELER + " TEXT,"
                + KEY_LICENSE_COUNT_4_WHEELER + " TEXT,"
                + KEY_ONE_YEAR_MA_BIRAMI + " TEXT,"
                + KEY_BIRAMI_HUDA_KATA_LAGEKO + " TEXT,"
                + KEY_HEALTHPOST_JANA_HIDERA_TIME + " TEXT,"
                + KEY_HEALTHPOST_JANA_GAADI_TIME + " TEXT,"
                + KEY_TWO_YEAR_LE_VACCINE_LAGAYEKO + " TEXT,"
                + KEY_VACCINE_NAGAREKO_KARAN + " TEXT,"
                + KEY_TWO_YEAR_MA_PREGNANT + " TEXT,"
                + KEY_PREGNANT_KO_HEALTH_CHECKUP + " TEXT,"
                + KEY_PREGNANT_KO_CHECK_NAGARNE_KARAN + " TEXT,"
                + KEY_PREGNANT_KO_CHECK_GAREKO_COUNT + " TEXT,"
                + KEY_PREGNANT_LE_ICON_PILL_LINEGAREKO + " TEXT,"
                + KEY_PREGNANT_LE_JUKA_MEDICINE_LINEGAREKO + " TEXT,"
                + KEY_PREGNANT_LE_VITAMIN_LINEGAREKO + " TEXT,"
                + KEY_BACCHA_JANMAAUNE_STHAN + " TEXT,"
                + KEY_BACCHA_JANMAAUNA_SAHAYOG_GARNE + " TEXT,"
                + KEY_BACCHA_JANMAAUNA_HELP_NALINUKARAN + " TEXT,"
                + KEY_LAST12MONTHMA_UNDER_5YR_KO_DEATH + " TEXT,"
                + KEY_UNDER_5YR_DEATH_GENDER + " TEXT,"
                + KEY_UNDER_5YR_DEATH_AGE + " TEXT,"
                + KEY_UNDER_5YR_DEATH_KARAN + " TEXT,"
                + KEY_UNDER_5YR_KO_DEVELOPMENT_MEASURE_HUNCHA + " TEXT,"
                + KEY_AGE6MONTH_TO_6YR_VITAMIN_A + " TEXT,"
                + KEY_AGE1YR_TO_6YR_JUKA_MEDICINE + " TEXT,"
                + KEY_WINTER_MA_WARM_CLOTH + " TEXT,"
                + KEY_JHUUL_KO_BABYASTHA + " TEXT,"
                + KEY_REGULAR_HEALTH_CHECKUP_PERYEAR + " TEXT,"
                + KEY_PAST12MONTH_MA_DEATH_BHAYEKO + " TEXT,"
                + KEY_YOG_RA_ADHYATMIK_KENDRA_MA_JANEGAREKO + " TEXT,"
                + KEY_HEALTH_INSURANCE_GAREKO + " TEXT,"
                + KEY_THAP_PANI_KINNUPARNE + " TEXT,"
                + KEY_PAANI_AAUNE_ABADHI + " TEXT,"
                + KEY_PANI_BITARAN_GHANTA + " TEXT,"
                + KEY_KHANEPAANI_SOURCE + " TEXT,"
                + KEY_PAANI_METER_JADAN_GAREYEKO + " TEXT,"
                + KEY_PAANI_SUFFICIENT_HUNE + " TEXT,"
                + KEY_PAANI_LINA_JANE_AAUNE_TIME + " TEXT,"
                + KEY_KHANEPAANI_QUALITY + " TEXT,"
                + KEY_PANI_PURIFY_GARNE_GAREKO + " TEXT,"
                + KEY_PANI_PURIFY_GARNE_TARIKA + " TEXT,"
                + KEY_RAIN_WATER_COLLECT_GAREKO + " TEXT,"
                + KEY_RAINWATER_KO_USE + " TEXT,"
                + KEY_GHAAR_MA_DHAAL_ATTACH_BHAYEKO + " TEXT,"
                + KEY_DHAAL_ATTACH_BHAYEKO_TYPE + " TEXT,"
                + KEY_WASTE_WATER_MANAGEMENT + " TEXT,"
                + KEY_DECOMPOSE_NODECOMPOSE_SEPARATE_GARNE + " TEXT,"
                + KEY_SOLID_WASTE_MANAGEMENT + " TEXT,"

                + KEY_HASTOILET + " TEXT,"
                + KEY_TOILETTYPE + " TEXT,"
                + KEY_TOILET_KAHA_BHAYEKO + " TEXT,"
                + KEY_TOILETWASTEMGMT + " TEXT,"
                + KEY_ONLINESERVICES + " TEXT,"
                + KEY_PRIMARYINCOMESOURCE + " TEXT,"

                + KEY_PRIMARYAGROPRODUCTIONS + " TEXT,"
                + KEY_ANNABALI_MURI + " TEXT,"
                + KEY_DHAN_MURI + " TEXT,"
                + KEY_MAKAI_MURI + " TEXT,"
                + KEY_KODO_MURI + " TEXT,"
                + KEY_GHAU_MURI + " TEXT,"
                + KEY_FAPAR_MURI + " TEXT,"
                + KEY_OIL_KG + " TEXT,"
                + KEY_DAAL_KG + " TEXT,"
                + KEY_TARKARI_KG + " TEXT,"
                + KEY_FRESHTARKARI_KG + " TEXT,"
                + KEY_AALU_KG + " TEXT,"
                + KEY_MASALA_KG + " TEXT,"
                + KEY_FALFUL_KG + " TEXT,"
                + KEY_KANDAMUL_KG + " TEXT,"
                + KEY_ALAUCHI_KG + " TEXT,"
                + KEY_SUPARI_KG + " TEXT,"
                + KEY_AMRISHO_KG + " TEXT,"
                + KEY_ADUWA_KG + " TEXT,"
                + KEY_AKABARE_KG + " TEXT,"
                + KEY_COFFEE_KG + " TEXT,"
                + KEY_OTHERS_KG + " TEXT,"

                + KEY_COW_STHANIYA + " TEXT,"
                + KEY_COW_UNNAT + " TEXT,"
                + KEY_BUFFALO_STHANIYA + " TEXT,"
                + KEY_BUFFALO_UNNAT + " TEXT,"
                + KEY_GOAT_STHANIYA + " TEXT,"
                + KEY_GOAT_UNNAT + " TEXT,"
                + KEY_SHEEP_STHANIYA + " TEXT,"
                + KEY_SHEEP_UNNAT + " TEXT,"
                + KEY_PIG_STHANIYA + " TEXT,"
                + KEY_PIG_UNNAT + " TEXT,"
                + KEY_OTHER_ANIMAL + " TEXT,"
                + KEY_HEN_STHANIYA + " TEXT,"
                + KEY_HEN_UNNAT + " TEXT,"
                + KEY_PIGEON_COUNT + " TEXT,"
                + KEY_OTHER_BIRDS + " TEXT,"
                + KEY_FISH_COUNT + " TEXT,"
                + KEY_FISH_POND_AREA + " TEXT,"
                + KEY_BEEHIVE_COUNT + " TEXT,"
                + KEY_OTHER_PASUPANCHI + " TEXT,"
                + KEY_MILKCURD_LITRE + " TEXT,"
                + KEY_GHEE_KG + " TEXT,"
                + KEY_OTHERDAIRY_KG + " TEXT,"
                + KEY_MEAT_KG + " TEXT,"
                + KEY_COMPOST_QUINTAL + " TEXT,"
                + KEY_URINE_LITRE + " TEXT,"
                + KEY_WOOL_KG + " TEXT,"
                + KEY_EGG_CRATE + " TEXT,"
                + KEY_FISH_KG + " TEXT,"
                + KEY_HONEY_KG + " TEXT,"
                + KEY_OTHER_PRODUCTION_KG + " TEXT,"

                + KEY_SELLSPRODUCTIONS + " TEXT,"
                + KEY_SELLPRODUCTIONLIST + " TEXT,"
                + KEY_SELLPRODUCTIONTO + " TEXT,"
                + KEY_HASFRUITPLANTS + " TEXT,"
                + KEY_HASVEGETABLECROPS + " TEXT,"
                + KEY_LASTYEARINCOME + " TEXT,"
                + KEY_LASTYEAREXPENSE + " TEXT,"
                + KEY_WORKSABROAD + " TEXT,"
                + KEY_REMITTANCESPENTON + " TEXT,"
                + KEY_LASTYEARINVESTMENTS + " TEXT,"
                + KEY_PRODUCTIONSSUSTAINABLEFOR + " TEXT,"
                + KEY_INCOMEISSUFFICIENT + " TEXT,"
                + KEY_ADDITIONALCASHSOURCE + " TEXT,"
                + KEY_HASTAKENLOAN + " TEXT,"
                + KEY_LOANSOURCE + " TEXT,"
                + KEY_TAKENLOANFOR + " TEXT,"
                + KEY_DURATIONTOCLEARLOAN + " TEXT,"
                + KEY_KNOWSSAMHIT + " TEXT,"
                + KEY_BUILTASPERSAMHIT + " TEXT,"
                + KEY_HASPERMISSIONBLUEPRINT + " TEXT,"
                + KEY_HASSAFEZONENEARHOUSE + " TEXT,"
                + KEY_HOUSESUSCEPTTOCALAMITY + " TEXT,"
                + KEY_INFOABOUTEARTHQUAKE + " TEXT,"
                + KEY_KNOWSAFEZONEINHOME + " TEXT,"
                + KEY_HASSUPPLIESFORSOE + " TEXT,"
                + KEY_AFFECTEDBYCALAMITIESLIST + " TEXT,"
                + KEY_LASTMAJORDISASTERNAME + " TEXT,"
                + KEY_LASTMAJORDISASTERYEAR + " TEXT,"
                + KEY_LASTMAJORDISASTERDAMAGE + " TEXT,"
                + KEY_HASASSETINSURANCE + " TEXT,"
                + KEY_ASSETSLISTWITHINSURANCE + " TEXT,"
                + KEY_STEPSTAKENTOMINIMIZEDISASTEREFFECTS + " TEXT,"
                + KEY_ISVIOLENCEVICTIM + " TEXT,"
                + KEY_DEATHCOUNT + " TEXT,"
                + KEY_INJURYCOUNT + " TEXT,"
                + KEY_MISSINGCOUNT + " TEXT,"
                + KEY_ASSETLOSSAMOUNTRS + " TEXT,"
                + KEY_ISSUED + " TEXT,"
                + KEY_ISSHIFTED + " TEXT,"
                + KEY_ISSEXUALLYABUSE + " TEXT,"
                + KEY_MEMBERMISSING + " TEXT,"
                + KEY_FEELSSAFEINMUNICIPAL + " TEXT,"
                + KEY_REASONFEELSSAFE + " TEXT,"
                + KEY_REASONNOFEELSAFE + " TEXT,"
                + KEY_WARDNOWHERENOTFEELSAFE + " TEXT,"
                + KEY_REGIONNAMEWHERENOTFEELSAFE + " TEXT,"
                + KEY_HOMEMEMBERUPTOAGE16WORKS + " TEXT,"
                + KEY_UPTOAGE16WORINGBOYCOUNT + " TEXT,"
                + KEY_UPTOAGE16WORKINGGIRLCOUNT + " TEXT,"
                + KEY_MEMBERUPTOAGE16HIREDWORK + " TEXT,"
                + KEY_UPTOAGE16HIREDBOYCOUNT + " TEXT,"
                + KEY_UPTOAGE16HIREDGIRLCOUNT + " TEXT,"
                + KEY_CHILDRENISONBADINFLUENCE + " TEXT,"
                + KEY_CHILDRENBADINFLUENCEON + " TEXT,"
                + KEY_WAYOFMAKINGFAMILYDECISION + " TEXT,"
                + KEY_ASSETSONFEMALENAME + " TEXT,"
                + KEY_ALLOWANCELISTTAKENBYFAMILY + " TEXT,"
                + KEY_MEMBERHASINVOLVEDONDEVELOPMENT + " TEXT,"
                + KEY_OPINIONONDEVELOPMENTPRIORITY + " TEXT,"

                + KEY_INCOMEAGRICULTURE + " TEXT,"
                + KEY_INCOMEBUSINESS + " TEXT,"
                + KEY_INCOMESALARYPENSION + " TEXT,"
                + KEY_INCOMESOCIALALLOWANCE + " TEXT,"
                + KEY_INCOMEFOREIGNEMP + " TEXT,"
                + KEY_INCOMEWAGES + " TEXT,"
                + KEY_INCOMERENT + " TEXT,"
                + KEY_INCOMEINTERESTINVEST + " TEXT,"
                + KEY_INCOMEOTHERS + " TEXT,"
                + KEY_EXPENSEFOOD + " TEXT,"
                + KEY_EXPENSECLOTH + " TEXT,"
                + KEY_EXPENSEEDUCATION + " TEXT,"
                + KEY_EXPENSEHEALTH + " TEXT,"
                + KEY_EXPENSEENTERTAIN + " TEXT,"
                + KEY_EXPENSERENT + " TEXT,"
                + KEY_EXPENSEAGRICULTURE + " TEXT,"
                + KEY_EXPENSEINSTALLMENT + " TEXT,"
                + KEY_EXPENSEFUEL + " TEXT,"
                + KEY_EXPENSETRANPORT + " TEXT,"
                + KEY_EXPENSEOTHERS + " TEXT,"

                + KEY_KUNAI_MEMBER_KO_BANK_ACCOUNT + " TEXT,"
                + KEY_DISABILITY_COUNT + " TEXT,"
                + KEY_DISABILITY_TYPES + " TEXT,"
                + KEY_DISABILITY_CARD_COUNT + " TEXT,"
                + KEY_FAMILY_DISEASE_12MONTH + " TEXT,"
                + KEY_FAMILY_DIRGA_ROG + " TEXT,"
                + KEY_FAMILY_DIRGA_ROG_LIST + " TEXT,"
                + KEY_FAMILY_SARUWA_ROG + " TEXT,"
                + KEY_FAMILY_SARUWA_ROG_LIST + " TEXT,"
                + KEY_FAMILY_NAGARIK_PASSPORT_PENSION_JANMADARTA_JAGGADHANI_EARTHQUAKECARD_COUNT + " TEXT,"
                + KEY_FAMILY_ALLOWANCE_DEPRIVED_COUNT + " TEXT,"
                + KEY_UNMARRIED_MEMBER_COUNT + " TEXT,"
                + KEY_MARRIED_MEMBER_COUNT + " TEXT,"
                + KEY_POLYGAMY_MEMBER_COUNT + " TEXT,"
                + KEY_REMARRIED_MEMBER_COUNT + " TEXT,"
                + KEY_SINGLE_MEMBER_COUNT + " TEXT,"
                + KEY_DIVORCED_MEMBER_COUNT + " TEXT,"
                + KEY_BREAKUP_NOTDIVORCED_MEMBER_COUNT + " TEXT,"

                + KEY_RAJNITIK_KENDRIA_LEVEL_COUNT + " TEXT,"
                + KEY_RAJNITIK_PRADESH_LEVEL_COUNT + " TEXT,"
                + KEY_RAJNITIK_JILLA_LEVEL_COUNT + " TEXT,"
                + KEY_RAJNITIK_PALIKA_LEVEL_COUNT + " TEXT,"
                + KEY_RAJNITIK_WARD_LEVEL_COUNT + " TEXT,"

                + KEY_BUSINESS_MEMBER_COUNT + " TEXT,"
                + KEY_JOB_MEMBER_COUNT + " TEXT,"
                + KEY_STUDY_MEMBER_COUNT + " TEXT,"

                + KEY_FAMILY_COUNT + " TEXT,"
                + MEMBER_1_KEY_NAME_THAR + " TEXT,"
                + MEMBER_1_KEY_GENDER + " TEXT,"
                + MEMBER_1_KEY_AGE + " TEXT,"
                + MEMBER_1_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_1_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_1_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_1_KEY_EDUCATION + " TEXT,"
                + MEMBER_1_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_1_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_1_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_1_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_1_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_1_KEY_SKILLS + " TEXT,"
                + MEMBER_1_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_1_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_1_KEY_USESVACCINE + " TEXT,"
                + MEMBER_1_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_1_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_1_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_1_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_1_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_1_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_1_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_1_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_1_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_1_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_1_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_2_KEY_NAME_THAR + " TEXT,"
                + MEMBER_2_KEY_GENDER + " TEXT,"
                + MEMBER_2_KEY_AGE + " TEXT,"
                + MEMBER_2_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_2_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_2_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_2_KEY_EDUCATION + " TEXT,"
                + MEMBER_2_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_2_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_2_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_2_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_2_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_2_KEY_SKILLS + " TEXT,"
                + MEMBER_2_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_2_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_2_KEY_USESVACCINE + " TEXT,"
                + MEMBER_2_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_2_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_2_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_2_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_2_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_2_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_2_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_2_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_2_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_2_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_2_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_3_KEY_NAME_THAR + " TEXT,"
                + MEMBER_3_KEY_GENDER + " TEXT,"
                + MEMBER_3_KEY_AGE + " TEXT,"
                + MEMBER_3_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_3_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_3_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_3_KEY_EDUCATION + " TEXT,"
                + MEMBER_3_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_3_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_3_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_3_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_3_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_3_KEY_SKILLS + " TEXT,"
                + MEMBER_3_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_3_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_3_KEY_USESVACCINE + " TEXT,"
                + MEMBER_3_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_3_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_3_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_3_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_3_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_3_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_3_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_3_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_3_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_3_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_3_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_4_KEY_NAME_THAR + " TEXT,"
                + MEMBER_4_KEY_GENDER + " TEXT,"
                + MEMBER_4_KEY_AGE + " TEXT,"
                + MEMBER_4_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_4_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_4_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_4_KEY_EDUCATION + " TEXT,"
                + MEMBER_4_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_4_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_4_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_4_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_4_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_4_KEY_SKILLS + " TEXT,"
                + MEMBER_4_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_4_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_4_KEY_USESVACCINE + " TEXT,"
                + MEMBER_4_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_4_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_4_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_4_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_4_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_4_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_4_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_4_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_4_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_4_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_4_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_5_KEY_NAME_THAR + " TEXT,"
                + MEMBER_5_KEY_GENDER + " TEXT,"
                + MEMBER_5_KEY_AGE + " TEXT,"
                + MEMBER_5_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_5_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_5_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_5_KEY_EDUCATION + " TEXT,"
                + MEMBER_5_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_5_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_5_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_5_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_5_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_5_KEY_SKILLS + " TEXT,"
                + MEMBER_5_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_5_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_5_KEY_USESVACCINE + " TEXT,"
                + MEMBER_5_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_5_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_5_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_5_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_5_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_5_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_5_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_5_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_5_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_5_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_5_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_6_KEY_NAME_THAR + " TEXT,"
                + MEMBER_6_KEY_GENDER + " TEXT,"
                + MEMBER_6_KEY_AGE + " TEXT,"
                + MEMBER_6_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_6_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_6_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_6_KEY_EDUCATION + " TEXT,"
                + MEMBER_6_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_6_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_6_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_6_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_6_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_6_KEY_SKILLS + " TEXT,"
                + MEMBER_6_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_6_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_6_KEY_USESVACCINE + " TEXT,"
                + MEMBER_6_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_6_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_6_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_6_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_6_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_6_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_6_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_6_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_6_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_6_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_6_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_7_KEY_NAME_THAR + " TEXT,"
                + MEMBER_7_KEY_GENDER + " TEXT,"
                + MEMBER_7_KEY_AGE + " TEXT,"
                + MEMBER_7_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_7_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_7_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_7_KEY_EDUCATION + " TEXT,"
                + MEMBER_7_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_7_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_7_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_7_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_7_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_7_KEY_SKILLS + " TEXT,"
                + MEMBER_7_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_7_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_7_KEY_USESVACCINE + " TEXT,"
                + MEMBER_7_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_7_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_7_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_7_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_7_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_7_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_7_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_7_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_7_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_7_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_7_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_8_KEY_NAME_THAR + " TEXT,"
                + MEMBER_8_KEY_GENDER + " TEXT,"
                + MEMBER_8_KEY_AGE + " TEXT,"
                + MEMBER_8_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_8_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_8_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_8_KEY_EDUCATION + " TEXT,"
                + MEMBER_8_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_8_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_8_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_8_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_8_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_8_KEY_SKILLS + " TEXT,"
                + MEMBER_8_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_8_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_8_KEY_USESVACCINE + " TEXT,"
                + MEMBER_8_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_8_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_8_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_8_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_8_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_8_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_8_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_8_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_8_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_8_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_8_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_9_KEY_NAME_THAR + " TEXT,"
                + MEMBER_9_KEY_GENDER + " TEXT,"
                + MEMBER_9_KEY_AGE + " TEXT,"
                + MEMBER_9_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_9_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_9_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_9_KEY_EDUCATION + " TEXT,"
                + MEMBER_9_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_9_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_9_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_9_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_9_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_9_KEY_SKILLS + " TEXT,"
                + MEMBER_9_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_9_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_9_KEY_USESVACCINE + " TEXT,"
                + MEMBER_9_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_9_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_9_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_9_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_9_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_9_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_9_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_9_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_9_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_9_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_9_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_10_KEY_NAME_THAR + " TEXT,"
                + MEMBER_10_KEY_GENDER + " TEXT,"
                + MEMBER_10_KEY_AGE + " TEXT,"
                + MEMBER_10_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_10_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_10_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_10_KEY_EDUCATION + " TEXT,"
                + MEMBER_10_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_10_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_10_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_10_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_10_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_10_KEY_SKILLS + " TEXT,"
                + MEMBER_10_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_10_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_10_KEY_USESVACCINE + " TEXT,"
                + MEMBER_10_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_10_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_10_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_10_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_10_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_10_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_10_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_10_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_10_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_10_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_10_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_11_KEY_NAME_THAR + " TEXT,"
                + MEMBER_11_KEY_GENDER + " TEXT,"
                + MEMBER_11_KEY_AGE + " TEXT,"
                + MEMBER_11_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_11_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_11_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_11_KEY_EDUCATION + " TEXT,"
                + MEMBER_11_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_11_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_11_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_11_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_11_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_11_KEY_SKILLS + " TEXT,"
                + MEMBER_11_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_11_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_11_KEY_USESVACCINE + " TEXT,"
                + MEMBER_11_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_11_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_11_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_11_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_11_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_11_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_11_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_11_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_11_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_11_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_11_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_12_KEY_NAME_THAR + " TEXT,"
                + MEMBER_12_KEY_GENDER + " TEXT,"
                + MEMBER_12_KEY_AGE + " TEXT,"
                + MEMBER_12_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_12_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_12_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_12_KEY_EDUCATION + " TEXT,"
                + MEMBER_12_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_12_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_12_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_12_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_12_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_12_KEY_SKILLS + " TEXT,"
                + MEMBER_12_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_12_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_12_KEY_USESVACCINE + " TEXT,"
                + MEMBER_12_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_12_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_12_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_12_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_12_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_12_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_12_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_12_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_12_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_12_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_12_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_13_KEY_NAME_THAR + " TEXT,"
                + MEMBER_13_KEY_GENDER + " TEXT,"
                + MEMBER_13_KEY_AGE + " TEXT,"
                + MEMBER_13_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_13_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_13_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_13_KEY_EDUCATION + " TEXT,"
                + MEMBER_13_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_13_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_13_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_13_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_13_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_13_KEY_SKILLS + " TEXT,"
                + MEMBER_13_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_13_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_13_KEY_USESVACCINE + " TEXT,"
                + MEMBER_13_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_13_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_13_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_13_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_13_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_13_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_13_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_13_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_13_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_13_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_13_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_14_KEY_NAME_THAR + " TEXT,"
                + MEMBER_14_KEY_GENDER + " TEXT,"
                + MEMBER_14_KEY_AGE + " TEXT,"
                + MEMBER_14_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_14_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_14_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_14_KEY_EDUCATION + " TEXT,"
                + MEMBER_14_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_14_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_14_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_14_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_14_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_14_KEY_SKILLS + " TEXT,"
                + MEMBER_14_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_14_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_14_KEY_USESVACCINE + " TEXT,"
                + MEMBER_14_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_14_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_14_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_14_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_14_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_14_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_14_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_14_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_14_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_14_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_14_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_15_KEY_NAME_THAR + " TEXT,"
                + MEMBER_15_KEY_GENDER + " TEXT,"
                + MEMBER_15_KEY_AGE + " TEXT,"
                + MEMBER_15_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_15_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_15_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_15_KEY_EDUCATION + " TEXT,"
                + MEMBER_15_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_15_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_15_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_15_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_15_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_15_KEY_SKILLS + " TEXT,"
                + MEMBER_15_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_15_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_15_KEY_USESVACCINE + " TEXT,"
                + MEMBER_15_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_15_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_15_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_15_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_15_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_15_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_15_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_15_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_15_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_15_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_15_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_16_KEY_NAME_THAR + " TEXT,"
                + MEMBER_16_KEY_GENDER + " TEXT,"
                + MEMBER_16_KEY_AGE + " TEXT,"
                + MEMBER_16_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_16_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_16_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_16_KEY_EDUCATION + " TEXT,"
                + MEMBER_16_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_16_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_16_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_16_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_16_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_16_KEY_SKILLS + " TEXT,"
                + MEMBER_16_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_16_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_16_KEY_USESVACCINE + " TEXT,"
                + MEMBER_16_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_16_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_16_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_16_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_16_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_16_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_16_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_16_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_16_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_16_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_16_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_17_KEY_NAME_THAR + " TEXT,"
                + MEMBER_17_KEY_GENDER + " TEXT,"
                + MEMBER_17_KEY_AGE + " TEXT,"
                + MEMBER_17_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_17_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_17_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_17_KEY_EDUCATION + " TEXT,"
                + MEMBER_17_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_17_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_17_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_17_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_17_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_17_KEY_SKILLS + " TEXT,"
                + MEMBER_17_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_17_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_17_KEY_USESVACCINE + " TEXT,"
                + MEMBER_17_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_17_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_17_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_17_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_17_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_17_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_17_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_17_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_17_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_17_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_17_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_18_KEY_NAME_THAR + " TEXT,"
                + MEMBER_18_KEY_GENDER + " TEXT,"
                + MEMBER_18_KEY_AGE + " TEXT,"
                + MEMBER_18_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_18_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_18_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_18_KEY_EDUCATION + " TEXT,"
                + MEMBER_18_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_18_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_18_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_18_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_18_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_18_KEY_SKILLS + " TEXT,"
                + MEMBER_18_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_18_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_18_KEY_USESVACCINE + " TEXT,"
                + MEMBER_18_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_18_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_18_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_18_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_18_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_18_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_18_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_18_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_18_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_18_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_18_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_19_KEY_NAME_THAR + " TEXT,"
                + MEMBER_19_KEY_GENDER + " TEXT,"
                + MEMBER_19_KEY_AGE + " TEXT,"
                + MEMBER_19_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_19_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_19_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_19_KEY_EDUCATION + " TEXT,"
                + MEMBER_19_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_19_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_19_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_19_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_19_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_19_KEY_SKILLS + " TEXT,"
                + MEMBER_19_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_19_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_19_KEY_USESVACCINE + " TEXT,"
                + MEMBER_19_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_19_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_19_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_19_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_19_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_19_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_19_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_19_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_19_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_19_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_19_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_20_KEY_NAME_THAR + " TEXT,"
                + MEMBER_20_KEY_GENDER + " TEXT,"
                + MEMBER_20_KEY_AGE + " TEXT,"
                + MEMBER_20_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_20_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_20_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_20_KEY_EDUCATION + " TEXT,"
                + MEMBER_20_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_20_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_20_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_20_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_20_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_20_KEY_SKILLS + " TEXT,"
                + MEMBER_20_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_20_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_20_KEY_USESVACCINE + " TEXT,"
                + MEMBER_20_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_20_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_20_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_20_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_20_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_20_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_20_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_20_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_20_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_20_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_20_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_21_KEY_NAME_THAR + " TEXT,"
                + MEMBER_21_KEY_GENDER + " TEXT,"
                + MEMBER_21_KEY_AGE + " TEXT,"
                + MEMBER_21_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_21_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_21_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_21_KEY_EDUCATION + " TEXT,"
                + MEMBER_21_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_21_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_21_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_21_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_21_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_21_KEY_SKILLS + " TEXT,"
                + MEMBER_21_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_21_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_21_KEY_USESVACCINE + " TEXT,"
                + MEMBER_21_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_21_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_21_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_21_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_21_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_21_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_21_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_21_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_21_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_21_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_21_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_22_KEY_NAME_THAR + " TEXT,"
                + MEMBER_22_KEY_GENDER + " TEXT,"
                + MEMBER_22_KEY_AGE + " TEXT,"
                + MEMBER_22_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_22_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_22_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_22_KEY_EDUCATION + " TEXT,"
                + MEMBER_22_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_22_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_22_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_22_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_22_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_22_KEY_SKILLS + " TEXT,"
                + MEMBER_22_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_22_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_22_KEY_USESVACCINE + " TEXT,"
                + MEMBER_22_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_22_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_22_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_22_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_22_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_22_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_22_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_22_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_22_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_22_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_22_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_23_KEY_NAME_THAR + " TEXT,"
                + MEMBER_23_KEY_GENDER + " TEXT,"
                + MEMBER_23_KEY_AGE + " TEXT,"
                + MEMBER_23_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_23_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_23_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_23_KEY_EDUCATION + " TEXT,"
                + MEMBER_23_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_23_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_23_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_23_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_23_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_23_KEY_SKILLS + " TEXT,"
                + MEMBER_23_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_23_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_23_KEY_USESVACCINE + " TEXT,"
                + MEMBER_23_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_23_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_23_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_23_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_23_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_23_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_23_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_23_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_23_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_23_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_23_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_24_KEY_NAME_THAR + " TEXT,"
                + MEMBER_24_KEY_GENDER + " TEXT,"
                + MEMBER_24_KEY_AGE + " TEXT,"
                + MEMBER_24_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_24_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_24_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_24_KEY_EDUCATION + " TEXT,"
                + MEMBER_24_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_24_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_24_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_24_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_24_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_24_KEY_SKILLS + " TEXT,"
                + MEMBER_24_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_24_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_24_KEY_USESVACCINE + " TEXT,"
                + MEMBER_24_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_24_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_24_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_24_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_24_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_24_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_24_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_24_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_24_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_24_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_24_KEY_TRAVELOTHERSTO + " TEXT,"

                + MEMBER_25_KEY_NAME_THAR + " TEXT,"
                + MEMBER_25_KEY_GENDER + " TEXT,"
                + MEMBER_25_KEY_AGE + " TEXT,"
                + MEMBER_25_KEY_RELATION_TO_OWNER + " TEXT,"
                + MEMBER_25_KEY_LEAVE_HOME_6MONTH + " TEXT,"
                + MEMBER_25_KEY_LEAVE_HOME_REASON + " TEXT,"
                + MEMBER_25_KEY_EDUCATION + " TEXT,"
                + MEMBER_25_KEY_SCHOOL_TYPE + " TEXT,"
                + MEMBER_25_KEY_LEAVE_SCHOOL_REASON + " TEXT,"
                + MEMBER_25_KEY_INCOME_SOURCE + " TEXT,"
                + MEMBER_25_KEY_ABROAD_COUNTRY + " TEXT,"
                + MEMBER_25_KEY_ABROAD_MONEYTRANSFER + " TEXT,"
                + MEMBER_25_KEY_SKILLS + " TEXT,"
                + MEMBER_25_KEY_REGULARDEPOSIT + " TEXT,"
                + MEMBER_25_KEY_REGULARDEPOSIT_TO + " TEXT,"
                + MEMBER_25_KEY_USESVACCINE + " TEXT,"
                + MEMBER_25_KEY_SOCIALINVOLVEMENTS + " TEXT,"
                + MEMBER_25_KEY_HASRECEIVEDTRAINING + " TEXT,"
                + MEMBER_25_KEY_TRAININGLIST + " TEXT,"
                + MEMBER_25_KEY_TRAVELWORK + " TEXT,"
                + MEMBER_25_KEY_TRAVELWORKTO + " TEXT,"
                + MEMBER_25_KEY_TRAVELBUSINESS + " TEXT,"
                + MEMBER_25_KEY_TRAVELBUSINESSTO + " TEXT,"
                + MEMBER_25_KEY_TRAVELEDUCATION + " TEXT,"
                + MEMBER_25_KEY_TRAVELEDUCATIONTO + " TEXT,"
                + MEMBER_25_KEY_TRAVELOTHERS + " TEXT,"
                + MEMBER_25_KEY_TRAVELOTHERSTO + " TEXT"

                + ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    //CRUDE
    public void addDetail(Details details, Details2 details2, HouseholdData houseData, ShiftedQuestion shiftQuestion, int familyCount, FamilyMemberData[] familyData) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_LAT, details.getLatitude());
        values.put(KEY_LNG, details.getLongitude());
        values.put(KEY_ALT, details.getAltitude());
        values.put(KEY_HOUSE_CODE, details2.getHouse_code());
        values.put(KEY_PRADESH, details.getPradesh());
        values.put(KEY_JILLA, details.getJilla());
        values.put(KEY_NAGARPALIKA, details.getNagarpalika());
        values.put(KEY_WARD, details.getWard());
        values.put(KEY_BASTI, details.getBasti());
        values.put(KEY_TOLENAME, details.getTole());
        values.put(KEY_SADAKNAME, details.getSadak());
        values.put(KEY_GHARDHANINAME, details.getGhardhaniname());
        values.put(KEY_GHARDHANISEX, details.getGhardhanisex());
        values.put(KEY_GHARDHANIPHONE, details.getGhardhaniphone());

        values.put(KEY_TENANT_FAMILY_COUNT, details2.getTenant_family_count());
        values.put(KEY_HOME_BUSINESS, details2.getHouse_has_business());
        values.put(KEY_INFORMER_NAME, details2.getInformer_name());
        values.put(KEY_INFORMER_GENDER, details2.getInformer_gender());
        values.put(KEY_INFORMER_AGE, details2.getInformer_age());
        values.put(KEY_INFORMER_EMAIL, details2.getInformer_email());
        values.put(KEY_SWAMITTO, details2.getSwamitto());
        values.put(KEY_BASAI_ABADHI, details2.getBasai_abadhi());
        values.put(KEY_JATIYA_SAMUHA, details2.getJatiya_samuha());
        values.put(KEY_JATJATI, details2.getJatjati());
        values.put(KEY_DHARMA, details2.getDharma());
        values.put(KEY_MATRIBHASHA, details2.getMatribhasha());

        values.put(KEY_PARIWAR_BASOBAS_AVASTHA, details2.getPariwar_basobas_avastha());
        values.put(KEY_KUN_STHAN_BATA_BASAI_SAREKO, details2.getKata_bata_aako());
        values.put(KEY_BASAI_SARNU_KARAN, details2.getBasai_sarnu_karan());
        values.put(KEY_BASAI_AVADHI, details2.getBasai_avadhi());
        values.put(KEY_NAGARPALIKA_MA_GHAR_BHAYEKO, details2.getNagarpalika_ma_ghar_bhayeko());
        values.put(KEY_GHAR_JAGGA_SWAMITTO_KISIM, details2.getGhar_jagga_swamitto_kisim());
        values.put(KEY_JAGGA_KO_AREA, details2.getJagga_area());
        values.put(KEY_SICHAI_JAGGA_KO_AREA, details2.getSichai_jagga_area());
        values.put(KEY_NAGARPALIKA_MA_ANYA_GHAR_BHAYEKO, details2.getNagarpalika_ma_anya_ghar_bhayeko());
        values.put(KEY_ANYA_GHAR_K_KO_LAGI, details2.getAnya_ghar_k_ko_lagi());

        values.put(KEY_OWNSLAND, houseData.getOwnsLand());
        values.put(KEY_LANDLOCATION, houseData.getLandLocation());
        values.put(KEY_LANDOWNEDBY, houseData.getLandOwnedBy());
        values.put(KEY_LANDUSEDAS, houseData.getLandUsedAs());
        values.put(KEY_LANDONLEASE, houseData.getLandOnLease());
        values.put(KEY_LANDONLEASEUSEDAS, houseData.getLandOnLeaseUsedAs());

        values.put(KEY_GHAR_KO_PRAKAR, details2.getGhar_type());
        values.put(KEY_GHAR_EARTHQUAKE_PROOF, details2.getGhar_earthquake());
        values.put(KEY_GHAR_ROOF_TYPE, details2.getGhar_roof_type());
        values.put(KEY_KITCHEN_ALAGGAI_BHAYEKO, details2.getKitchen_alaggai_bhayeko());
        values.put(KEY_KARESOBARI_BHAYEKO, details2.getKaresabari_bhayeko());
        values.put(KEY_GHAR_NIRMAN_AVASTHA, details2.getGhar_nirman_avastha());
        values.put(KEY_GHAR_NIRMAN_BARSA, details2.getGhar_nirman_barsa());
        values.put(KEY_BATTI_MAIN_SOURCE, details2.getBatti_main_source());
        values.put(KEY_ELECTRICITY_JADAN_BHAYEKO, details2.getElectricity_jadan_bhayeko());
        values.put(KEY_ELECTRICITY_JADAN_KINA_NABHAYEKO, details2.getElectricity_jadan_kina_nabhayeko());

        values.put(KEY_CHULO_KO_PRAKAR, details2.getCulo_ko_prakar());
        values.put(KEY_PAKAUNE_FUEL, details2.getPakaune_fuel());
        values.put(KEY_DAAURA_KO_SOURCE, details2.getDaaura_ko_source());
        values.put(KEY_GAS_CYLINDER_TIKNE_DIN, details2.getGas_cylinder_tikne_din());
        values.put(KEY_OLD_CHULO_KO_LAGI_DAAURA_KG, details2.getOld_chulo_ko_lagi_daaura_kg());
        values.put(KEY_MODERN_CHULO_KO_LAGI_DAAURA_KG, details2.getModern_chulo_ko_lagi_daaura_kg());
        values.put(KEY_MATTITEL_PERMONTH_LITRE, details2.getMattitel_permonth_litre());
        values.put(KEY_INDUCTION_HEATER_HOURSPERDAY, details2.getInduction_heater_hoursperday());
        values.put(KEY_OVEN_HOURSPERDAY, details2.getOven_hoursperday());
        values.put(KEY_PAANI_TATAUNA_CYLINDERPERYEAR, details2.getPaani_tatauna_cylinderperyear());
        values.put(KEY_PAANI_TATAUNA_WOOD_KGPERMONTH_OLD_CHULO, details2.getPaani_tatauna_wood_kgpermonth_old_chulo());
        values.put(KEY_PAANI_TATAUNA_WOOD_KGPERMONTH_MODERN, details2.getPaani_tatauna_wood_kgpermonth_modern());
        values.put(KEY_PAANI_TATAUNA_MATTITEL_PERMONTH, details2.getPaani_tatauna_mattitel_permonth());
        values.put(KEY_PAANI_TATAUNA_INDUCTION_HOURSPERDAY, details2.getPaani_tatauna_induction_hoursperday());
        values.put(KEY_PAANI_TATAUNA_OVEN_HOURSPERDAY, details2.getPaani_tatauna_oven_hoursperday());

        values.put(KEY_ROOM_HEATING_UPAKARAN, details2.getRoom_heating_upakaran());
        values.put(KEY_ROOM_COOLING_UPAKARAN, details2.getRoom_cooling_upakaran());
        values.put(KEY_FAN_COUNT, details2.getFan_count());
        values.put(KEY_FAN_HOURSPERDAY, details2.getFan_hoursperday());
        values.put(KEY_AIRCONDITION_COUNT, details2.getAircondition_count());
        values.put(KEY_AIRCONDITION_HOURSPERDAY, details2.getAircondition_hoursperday());
        values.put(KEY_BIJULI_UNIT, details2.getBijuli_unit());
        values.put(KEY_WASHINGMACHINE_COUNT, details2.getWashingmachine_count());
        values.put(KEY_FRIDGE_COUNT, details2.getFridge_count());
        values.put(KEY_SOLAR_COUNT, details2.getSolar_count());
        values.put(KEY_VACUUM_COUNT, details2.getVacuum_count());
        values.put(KEY_INVERTER_COUNT, details2.getInverter_count());
        values.put(KEY_GENERATOR_COUNT, details2.getGenerator_count());
        values.put(KEY_DISHWASHER_COUNT, details2.getDishwasher_count());
        values.put(KEY_CABLE_COUNT, details2.getCable_count());
        values.put(KEY_OTHER_HOUSE_GADGET_COUNT, details2.getOther_house_gadget_count());
        values.put(KEY_RADIO_COUNT, details2.getRadio_count());
        values.put(KEY_TELEVISION_COUNT, details2.getTelevision_count());
        values.put(KEY_TELEPHONE_COUNT, details2.getTelephone_count());
        values.put(KEY_CELLPHONE_COUNT, details2.getCellphone_count());
        values.put(KEY_SMARTPHONE_COUNT, details2.getSmartphone_count());
        values.put(KEY_COMPUTER_LAPTOP_COUNT, details2.getComputer_laptop_count());
        values.put(KEY_INTERNET_COUNT, details2.getInternet_count());
        values.put(KEY_OTHER_COMMUNICATION_COUNT, details2.getOther_communication_count());
        values.put(KEY_INTERNET_SPEED_MBPS, details2.getInternet_speed_mbps());

        values.put(KEY_CYCLE_COUNT, details2.getCycle_count());
        values.put(KEY_BIKE_COUNT, details2.getBike_count());
        values.put(KEY_LIGHTWEIGHT_VEHICLE_COUNT, details2.getLightweight_vehicle_count());
        values.put(KEY_HEAVYWEIGHT_VEHICLE_COUNT, details2.getHeavyweight_vehicle_count());
        values.put(KEY_PUBLIC_TRANSPORT_VEHICLE_COUNT, details2.getPublic_transport_vehicle_count());
        values.put(KEY_FAMILY_MA_YATAYAT_LICENSE_BHAYEKO, details2.getFamily_ma_yatayat_license_bhayeko());
        values.put(KEY_LICENSE_BHAYEKO_COUNT, details2.getLicense_bhayeko_count());
        values.put(KEY_LICENSE_COUNT_2_WHEELER, details2.getLicense_count_2_wheeler());
        values.put(KEY_LICENSE_COUNT_4_WHEELER, details2.getLicense_count_4_wheeler());
        values.put(KEY_ONE_YEAR_MA_BIRAMI, details2.getOne_year_ma_birami());
        values.put(KEY_BIRAMI_HUDA_KATA_LAGEKO, details2.getBirami_huda_kata_lageko());
        values.put(KEY_HEALTHPOST_JANA_HIDERA_TIME, details2.getHealthpost_jana_hidera_time());
        values.put(KEY_HEALTHPOST_JANA_GAADI_TIME, details2.getHealthpost_jana_gaadi_time());
        values.put(KEY_TWO_YEAR_LE_VACCINE_LAGAYEKO, details2.getTwo_year_le_vaccine_lagayeko());
        values.put(KEY_VACCINE_NAGAREKO_KARAN, details2.getVaccine_nagareko_karan());

        values.put(KEY_TWO_YEAR_MA_PREGNANT, details2.getTwo_year_ma_pregnant());
        values.put(KEY_PREGNANT_KO_HEALTH_CHECKUP, details2.getPregnant_ko_health_checkup());
        values.put(KEY_PREGNANT_KO_CHECK_NAGARNE_KARAN, details2.getPregnant_ko_check_nagarne_karan());
        values.put(KEY_PREGNANT_KO_CHECK_GAREKO_COUNT, details2.getPregnant_ko_check_gareko_count());
        values.put(KEY_PREGNANT_LE_ICON_PILL_LINEGAREKO, details2.getPregnant_le_icon_pill_linegareko());
        values.put(KEY_PREGNANT_LE_JUKA_MEDICINE_LINEGAREKO, details2.getPregnant_le_juka_medicine_linegareko());
        values.put(KEY_PREGNANT_LE_VITAMIN_LINEGAREKO, details2.getPregnant_le_vitamin_linegareko());
        values.put(KEY_BACCHA_JANMAAUNE_STHAN, details2.getBaccha_janmaaune_sthan());
        values.put(KEY_BACCHA_JANMAAUNA_SAHAYOG_GARNE, details2.getBaccha_janmaauna_sahayog_garne());
        values.put(KEY_BACCHA_JANMAAUNA_HELP_NALINUKARAN, details2.getBaccha_janmaauna_help_nalinukaran());

        values.put(KEY_LAST12MONTHMA_UNDER_5YR_KO_DEATH, details2.getLast12Monthma_under_5yr_ko_death());
        values.put(KEY_UNDER_5YR_DEATH_GENDER, details2.getUnder_5yr_death_gender());
        values.put(KEY_UNDER_5YR_DEATH_AGE, details2.getUnder_5yr_death_age());
        values.put(KEY_UNDER_5YR_DEATH_KARAN, details2.getUnder_5yr_death_karan());
        values.put(KEY_UNDER_5YR_KO_DEVELOPMENT_MEASURE_HUNCHA, details2.getUnder_5yr_ko_development_measure_huncha());
        values.put(KEY_AGE6MONTH_TO_6YR_VITAMIN_A, details2.getAge6month_to_6yr_vitamin_A());
        values.put(KEY_AGE1YR_TO_6YR_JUKA_MEDICINE, details2.getAge1yr_to_6yr_juka_medicine());
        values.put(KEY_WINTER_MA_WARM_CLOTH, details2.getWinter_ma_warm_cloth());
        values.put(KEY_JHUUL_KO_BABYASTHA, details2.getJhuul_ko_babyastha());
        values.put(KEY_REGULAR_HEALTH_CHECKUP_PERYEAR, details2.getRegular_health_checkup_peryear());
        values.put(KEY_PAST12MONTH_MA_DEATH_BHAYEKO, details2.getPast12month_ma_death_bhayeko());
        values.put(KEY_YOG_RA_ADHYATMIK_KENDRA_MA_JANEGAREKO, details2.getYog_ra_adhyatmik_kendra_ma_janegareko());
        values.put(KEY_HEALTH_INSURANCE_GAREKO, details2.getHealth_insurance_bhayeko());

        values.put(KEY_KHANEPAANI_SOURCE, details2.getKhanepaani_source());
        values.put(KEY_PAANI_METER_JADAN_GAREYEKO, details2.getPaani_meter_jadan_gareyeko());
        values.put(KEY_PAANI_SUFFICIENT_HUNE, details2.getPaani_sufficient_hune());
        values.put(KEY_THAP_PANI_KINNUPARNE, details2.getThap_paani_kinnuparne());
        values.put(KEY_PAANI_AAUNE_ABADHI, details2.getPaani_aaune_abadhi());
        values.put(KEY_PANI_BITARAN_GHANTA, details2.getPaani_biraran_hours());
        values.put(KEY_PAANI_LINA_JANE_AAUNE_TIME, details2.getPaani_lina_jane_aaune_time());
        values.put(KEY_KHANEPAANI_QUALITY, details2.getKhanepaani_quality());
        values.put(KEY_PANI_PURIFY_GARNE_GAREKO, details2.getPani_purify_garne_gareko());
        values.put(KEY_PANI_PURIFY_GARNE_TARIKA, details2.getPani_purify_garne_tarika());
        values.put(KEY_RAIN_WATER_COLLECT_GAREKO, details2.getRain_water_collect_gareko());
        values.put(KEY_RAINWATER_KO_USE, details2.getRainwater_ko_use());
        values.put(KEY_GHAAR_MA_DHAAL_ATTACH_BHAYEKO, details2.getGhaar_ma_dhaal_attach_bhayeko());
        values.put(KEY_DHAAL_ATTACH_BHAYEKO_TYPE, details2.getDhaal_attach_bhayeko_type());
        values.put(KEY_WASTE_WATER_MANAGEMENT, details2.getWaste_water_management());
        values.put(KEY_DECOMPOSE_NODECOMPOSE_SEPARATE_GARNE, details2.getDecompose_nodecompose_separate_garne());
        values.put(KEY_SOLID_WASTE_MANAGEMENT, details2.getSolid_waste_management());

        values.put(KEY_HASTOILET, houseData.getHasToilet());
        values.put(KEY_TOILETTYPE, houseData.getToiletType());
        values.put(KEY_TOILET_KAHA_BHAYEKO, houseData.getToilet_kata_bhayeko());
        values.put(KEY_TOILETWASTEMGMT, houseData.getToiletWasteMgmt());
        values.put(KEY_ONLINESERVICES, houseData.getOnlineServices());
        values.put(KEY_PRIMARYINCOMESOURCE, houseData.getPrimaryIncomeSource());

        values.put(KEY_PRIMARYAGROPRODUCTIONS, houseData.getPrimaryAgroProductions());
        values.put(KEY_ANNABALI_MURI, houseData.getAnnabali_muri());
        values.put(KEY_DHAN_MURI, houseData.getDhan_muri());
        values.put(KEY_MAKAI_MURI, houseData.getMakai_muri());
        values.put(KEY_KODO_MURI, houseData.getKodo_muri());
        values.put(KEY_GHAU_MURI, houseData.getGhau_muri());
        values.put(KEY_FAPAR_MURI, houseData.getFapar_muri());
        values.put(KEY_OIL_KG, houseData.getOil_kg());
        values.put(KEY_DAAL_KG, houseData.getDaal_kg());
        values.put(KEY_TARKARI_KG, houseData.getTarkari_kg());
        values.put(KEY_FRESHTARKARI_KG, houseData.getFreshTarkari_kg());
        values.put(KEY_AALU_KG, houseData.getAalu_kg());
        values.put(KEY_MASALA_KG, houseData.getMasala_kg());
        values.put(KEY_FALFUL_KG, houseData.getFalful_kg());
        values.put(KEY_KANDAMUL_KG, houseData.getKandamul_kg());
        values.put(KEY_ALAUCHI_KG, houseData.getAlauchi_kg());
        values.put(KEY_SUPARI_KG, houseData.getSupari_kg());
        values.put(KEY_AMRISHO_KG, houseData.getAmrisho_kg());
        values.put(KEY_ADUWA_KG, houseData.getAduwa_kg());
        values.put(KEY_AKABARE_KG, houseData.getAkabare_kg());
        values.put(KEY_COFFEE_KG, houseData.getCoffee_kg());
        values.put(KEY_OTHERS_KG, houseData.getOthers_kg());

        values.put(KEY_COW_STHANIYA, houseData.getCow_sthaniya());
        values.put(KEY_COW_UNNAT, houseData.getCow_unnat());
        values.put(KEY_BUFFALO_STHANIYA, houseData.getBuffalo_sthaniya());
        values.put(KEY_BUFFALO_UNNAT, houseData.getBuffalo_unnat());
        values.put(KEY_GOAT_STHANIYA, houseData.getGoat_sthaniya());
        values.put(KEY_GOAT_UNNAT, houseData.getGoat_unnat());
        values.put(KEY_SHEEP_STHANIYA, houseData.getSheep_sthaniya());
        values.put(KEY_SHEEP_UNNAT, houseData.getSheep_unnat());
        values.put(KEY_PIG_STHANIYA, houseData.getPig_sthaniya());
        values.put(KEY_PIG_UNNAT, houseData.getPig_unnat());
        values.put(KEY_OTHER_ANIMAL, houseData.getOther_animal());
        values.put(KEY_HEN_STHANIYA, houseData.getHen_sthaniya());
        values.put(KEY_HEN_UNNAT, houseData.getHen_unnat());
        values.put(KEY_PIGEON_COUNT, houseData.getPigeon_count());
        values.put(KEY_OTHER_BIRDS, houseData.getOther_birds());
        values.put(KEY_FISH_COUNT, houseData.getFish_count());
        values.put(KEY_FISH_POND_AREA, houseData.getFish_pond_area());

        values.put(KEY_BEEHIVE_COUNT, houseData.getBeehive_count());
        values.put(KEY_OTHER_PASUPANCHI, houseData.getOther_pasupanchi());
        values.put(KEY_MILKCURD_LITRE, houseData.getMilkCurd_litre());
        values.put(KEY_GHEE_KG, houseData.getGhee_kg());
        values.put(KEY_OTHERDAIRY_KG, houseData.getOtherDairy_kg());
        values.put(KEY_MEAT_KG, houseData.getMeat_kg());
        values.put(KEY_COMPOST_QUINTAL, houseData.getCompost_quintal());
        values.put(KEY_URINE_LITRE, houseData.getUrine_litre());
        values.put(KEY_WOOL_KG, houseData.getWool_kg());
        values.put(KEY_EGG_CRATE, houseData.getEgg_crate());
        values.put(KEY_FISH_KG, houseData.getFish_kg());
        values.put(KEY_HONEY_KG, houseData.getHoney_kg());
        values.put(KEY_OTHER_PRODUCTION_KG, houseData.getOther_production_kg());

        values.put(KEY_SELLSPRODUCTIONS, houseData.getSellsProductions());
        values.put(KEY_SELLPRODUCTIONLIST, houseData.getSellProductionList());
        values.put(KEY_SELLPRODUCTIONTO, houseData.getSellProductionTo());
        values.put(KEY_HASFRUITPLANTS, houseData.getHasFruitPlants());

        values.put(KEY_HASVEGETABLECROPS, houseData.getHasVegetableCrops());
        values.put(KEY_LASTYEARINCOME, houseData.getLastYearIncome());
        values.put(KEY_LASTYEAREXPENSE, houseData.getLastYearExpense());
        values.put(KEY_WORKSABROAD, houseData.getWorksAbroad());
        values.put(KEY_REMITTANCESPENTON, houseData.getRemittanceSpentOn());
        values.put(KEY_LASTYEARINVESTMENTS, houseData.getLastYearInvestments());
        values.put(KEY_PRODUCTIONSSUSTAINABLEFOR, houseData.getProductionsSustainableFor());
        values.put(KEY_INCOMEISSUFFICIENT, houseData.getIncomeIsSufficient());
        values.put(KEY_ADDITIONALCASHSOURCE, houseData.getAdditionalCashSource());
        values.put(KEY_HASTAKENLOAN, houseData.getHasTakenLoan());
        values.put(KEY_LOANSOURCE, houseData.getLoanSource());
        values.put(KEY_TAKENLOANFOR, houseData.getTakenLoanFor());
        values.put(KEY_DURATIONTOCLEARLOAN, houseData.getDurationToClearLoan());
        values.put(KEY_KNOWSSAMHIT, houseData.getKnowsSamhit());
        values.put(KEY_BUILTASPERSAMHIT, houseData.getBuiltAsPerSamhit());
        values.put(KEY_HASPERMISSIONBLUEPRINT, houseData.getHasPermissionBlueprint());
        values.put(KEY_HASSAFEZONENEARHOUSE, houseData.getHasSafeZoneNearHouse());
        values.put(KEY_HOUSESUSCEPTTOCALAMITY, houseData.getHouseSusceptToCalamity());
        values.put(KEY_INFOABOUTEARTHQUAKE, houseData.getInfoAboutEarthquake());
        values.put(KEY_KNOWSAFEZONEINHOME, houseData.getKnowSafeZoneInHome());
        values.put(KEY_HASSUPPLIESFORSOE, houseData.getHasSuppliesForSOE());
        values.put(KEY_AFFECTEDBYCALAMITIESLIST, houseData.getAffectedByCalamitiesList());
        values.put(KEY_LASTMAJORDISASTERNAME, houseData.getLastMajorDisasterName());
        values.put(KEY_LASTMAJORDISASTERYEAR, houseData.getLastMajorDisasterYear());
        values.put(KEY_LASTMAJORDISASTERDAMAGE, houseData.getLastMajorDisasterDamage());
        values.put(KEY_HASASSETINSURANCE, houseData.getHasAssetInsurance());
        values.put(KEY_ASSETSLISTWITHINSURANCE, houseData.getAssetsListWithInsurance());
        values.put(KEY_STEPSTAKENTOMINIMIZEDISASTEREFFECTS, houseData.getStepsTakenToMinimizeDisasterEffects());
        values.put(KEY_ISVIOLENCEVICTIM, houseData.getIsViolenceVictim());
        values.put(KEY_DEATHCOUNT, houseData.getDeathCount());
        values.put(KEY_INJURYCOUNT, houseData.getInjuryCount());
        values.put(KEY_MISSINGCOUNT, houseData.getMissingCount());
        values.put(KEY_ASSETLOSSAMOUNTRS, houseData.getAssetLossAmountRs());
        values.put(KEY_ISSUED, houseData.getIsSued());
        values.put(KEY_ISSHIFTED, houseData.getIsShifted());
        values.put(KEY_ISSEXUALLYABUSE, houseData.getIsSexuallyAbuse());
        values.put(KEY_MEMBERMISSING, houseData.getMemberMissing());
        values.put(KEY_FEELSSAFEINMUNICIPAL, houseData.getFeelsSafeInMunicipal());
        values.put(KEY_REASONFEELSSAFE, houseData.getReasonFeelsSafe());
        values.put(KEY_REASONNOFEELSAFE, houseData.getReasonNoFeelSafe());
        values.put(KEY_WARDNOWHERENOTFEELSAFE, houseData.getWardNoWhereNotFeelSafe());
        values.put(KEY_REGIONNAMEWHERENOTFEELSAFE, houseData.getRegionNameWhereNotFeelSafe());
        values.put(KEY_HOMEMEMBERUPTOAGE16WORKS, houseData.getHomeMemberUptoAge16Works());
        values.put(KEY_UPTOAGE16WORINGBOYCOUNT, houseData.getUptoAge16WoringBoyCount());
        values.put(KEY_UPTOAGE16WORKINGGIRLCOUNT, houseData.getUptoAge16WorkingGirlCount());
        values.put(KEY_MEMBERUPTOAGE16HIREDWORK, houseData.getMemberUptoAge16HiredWork());
        values.put(KEY_UPTOAGE16HIREDBOYCOUNT, houseData.getUptoAge16HiredBoyCount());
        values.put(KEY_UPTOAGE16HIREDGIRLCOUNT, houseData.getUptoAge16HiredGirlCount());
        values.put(KEY_CHILDRENISONBADINFLUENCE, houseData.getChildrenIsOnBadInfluence());
        values.put(KEY_CHILDRENBADINFLUENCEON, houseData.getChildrenBadInfluenceOn());
        values.put(KEY_WAYOFMAKINGFAMILYDECISION, houseData.getWayOfMakingFamilyDecision());
        values.put(KEY_ASSETSONFEMALENAME, houseData.getAssetsOnFemaleName());
        values.put(KEY_ALLOWANCELISTTAKENBYFAMILY, houseData.getAllowanceListTakenByFamily());
        values.put(KEY_MEMBERHASINVOLVEDONDEVELOPMENT, houseData.getMemberHasInvolvedOnDevelopment());
        values.put(KEY_OPINIONONDEVELOPMENTPRIORITY, houseData.getOpinionOnDevelopmentPriority());

        values.put(KEY_INCOMEAGRICULTURE, houseData.getIncomeAgriculture());
        values.put(KEY_INCOMEBUSINESS, houseData.getIncomeBusiness());
        values.put(KEY_INCOMESALARYPENSION, houseData.getIncomeSalaryPension());
        values.put(KEY_INCOMESOCIALALLOWANCE, houseData.getIncomeSocialAllowance());
        values.put(KEY_INCOMEFOREIGNEMP, houseData.getIncomeForeignEmp());
        values.put(KEY_INCOMEWAGES, houseData.getIncomeWages());
        values.put(KEY_INCOMERENT, houseData.getIncomeRent());
        values.put(KEY_INCOMEINTERESTINVEST, houseData.getIncomeInterestInvest());
        values.put(KEY_INCOMEOTHERS, houseData.getIncomeOthers());
        values.put(KEY_EXPENSEFOOD, houseData.getExpenseFood());
        values.put(KEY_EXPENSECLOTH, houseData.getExpenseCloth());
        values.put(KEY_EXPENSEEDUCATION, houseData.getExpenseEducation());
        values.put(KEY_EXPENSEHEALTH, houseData.getExpenseHealth());
        values.put(KEY_EXPENSEENTERTAIN, houseData.getExpenseEntertain());
        values.put(KEY_EXPENSERENT, houseData.getExpenseRent());
        values.put(KEY_EXPENSEAGRICULTURE, houseData.getExpenseAgriculture());
        values.put(KEY_EXPENSEINSTALLMENT, houseData.getExpenseInstallment());
        values.put(KEY_EXPENSEFUEL, houseData.getExpenseFuel());
        values.put(KEY_EXPENSETRANPORT, houseData.getExpenseTranport());
        values.put(KEY_EXPENSEOTHERS, houseData.getExpenseOthers());

        values.put(KEY_KUNAI_MEMBER_KO_BANK_ACCOUNT, shiftQuestion.getKunai_member_ko_bank_account());
        values.put(KEY_DISABILITY_COUNT, shiftQuestion.getDisability_count());
        values.put(KEY_DISABILITY_TYPES, shiftQuestion.getDisability_types());
        values.put(KEY_DISABILITY_CARD_COUNT, shiftQuestion.getDisability_card_count());
        values.put(KEY_FAMILY_DISEASE_12MONTH, shiftQuestion.getFamily_disease_12month());
        values.put(KEY_FAMILY_DIRGA_ROG, shiftQuestion.getFamily_dirga_rog());
        values.put(KEY_FAMILY_DIRGA_ROG_LIST, shiftQuestion.getFamily_dirga_rog_list());
        values.put(KEY_FAMILY_SARUWA_ROG, shiftQuestion.getFamily_saruwa_rog());
        values.put(KEY_FAMILY_SARUWA_ROG_LIST, shiftQuestion.getFamily_saruwa_rog_list());
        values.put(KEY_FAMILY_NAGARIK_PASSPORT_PENSION_JANMADARTA_JAGGADHANI_EARTHQUAKECARD_COUNT, shiftQuestion.getFamily_nagarik_passport_pension_janmadarta_jaggadhani_earthquakecard_count());
        values.put(KEY_FAMILY_ALLOWANCE_DEPRIVED_COUNT, shiftQuestion.getFamily_allowance_deprived_count());
        values.put(KEY_UNMARRIED_MEMBER_COUNT, shiftQuestion.getUnmarried_member_count());
        values.put(KEY_MARRIED_MEMBER_COUNT, shiftQuestion.getMarried_member_count());
        values.put(KEY_POLYGAMY_MEMBER_COUNT, shiftQuestion.getPolygamy_member_count());
        values.put(KEY_REMARRIED_MEMBER_COUNT, shiftQuestion.getRemarried_member_count());
        values.put(KEY_SINGLE_MEMBER_COUNT, shiftQuestion.getSingle_member_count());
        values.put(KEY_DIVORCED_MEMBER_COUNT, shiftQuestion.getDivorced_member_count());
        values.put(KEY_BREAKUP_NOTDIVORCED_MEMBER_COUNT, shiftQuestion.getBreakup_notdivorced_member_count());

        values.put(KEY_RAJNITIK_KENDRIA_LEVEL_COUNT, shiftQuestion.getRajnitik_kendria_level_count());
        values.put(KEY_RAJNITIK_PRADESH_LEVEL_COUNT, shiftQuestion.getRajnitik_pradesh_level_count());
        values.put(KEY_RAJNITIK_JILLA_LEVEL_COUNT, shiftQuestion.getRajnitik_jilla_level_count());
        values.put(KEY_RAJNITIK_PALIKA_LEVEL_COUNT, shiftQuestion.getRajnitik_palika_level_count());
        values.put(KEY_RAJNITIK_WARD_LEVEL_COUNT, shiftQuestion.getRajnitik_ward_level_count());

        values.put(KEY_BUSINESS_MEMBER_COUNT, shiftQuestion.getBusiness_member_count());
        values.put(KEY_JOB_MEMBER_COUNT, shiftQuestion.getJob_member_count());
        values.put(KEY_STUDY_MEMBER_COUNT, shiftQuestion.getStudy_member_count());

        values.put(KEY_FAMILY_COUNT, familyCount);

        values.put(MEMBER_1_KEY_NAME_THAR, familyData[0].getName());
        values.put(MEMBER_1_KEY_GENDER, familyData[0].getGender());
        values.put(MEMBER_1_KEY_AGE, familyData[0].getAge());
        values.put(MEMBER_1_KEY_RELATION_TO_OWNER, familyData[0].getRelationToOwner());
        values.put(MEMBER_1_KEY_LEAVE_HOME_6MONTH, familyData[0].getHasLeftHome6Month());
        values.put(MEMBER_1_KEY_LEAVE_HOME_REASON, familyData[0].getLeaveHome_reason());
        values.put(MEMBER_1_KEY_EDUCATION, familyData[0].getEducation());
        values.put(MEMBER_1_KEY_SCHOOL_TYPE, familyData[0].getSchoolType());
        values.put(MEMBER_1_KEY_LEAVE_SCHOOL_REASON, familyData[0].getLeaveSchool_reason());
        values.put(MEMBER_1_KEY_INCOME_SOURCE, familyData[0].getIncomeSource());
        values.put(MEMBER_1_KEY_ABROAD_COUNTRY, familyData[0].getAbroad_country());
        values.put(MEMBER_1_KEY_ABROAD_MONEYTRANSFER, familyData[0].getAbroad_moneyTransfer());
        values.put(MEMBER_1_KEY_SKILLS, familyData[0].getSkills());
        values.put(MEMBER_1_KEY_REGULARDEPOSIT, familyData[0].getRegularDeposit());
        values.put(MEMBER_1_KEY_REGULARDEPOSIT_TO, familyData[0].getRegularDeposit_to());
        values.put(MEMBER_1_KEY_USESVACCINE, familyData[0].getUsesVaccine());
        values.put(MEMBER_1_KEY_SOCIALINVOLVEMENTS, familyData[0].getSocialInvolvements());
        values.put(MEMBER_1_KEY_HASRECEIVEDTRAINING, familyData[0].getHasReceivedTraining());
        values.put(MEMBER_1_KEY_TRAININGLIST, familyData[0].getTrainingList());
        values.put(MEMBER_1_KEY_TRAVELWORK, familyData[0].getTravelWork());
        values.put(MEMBER_1_KEY_TRAVELWORKTO, familyData[0].getTravelWorkTo());
        values.put(MEMBER_1_KEY_TRAVELBUSINESS, familyData[0].getTravelBusiness());
        values.put(MEMBER_1_KEY_TRAVELBUSINESSTO, familyData[0].getTravelBusinessTo());
        values.put(MEMBER_1_KEY_TRAVELEDUCATION, familyData[0].getTravelEducation());
        values.put(MEMBER_1_KEY_TRAVELEDUCATIONTO, familyData[0].getTravelEducationTo());
        values.put(MEMBER_1_KEY_TRAVELOTHERS, familyData[0].getTravelOthers());
        values.put(MEMBER_1_KEY_TRAVELOTHERSTO, familyData[0].getTravelOthersTo());


        values.put(MEMBER_2_KEY_NAME_THAR, familyData[1].getName());
        values.put(MEMBER_2_KEY_GENDER, familyData[1].getGender());
        values.put(MEMBER_2_KEY_AGE, familyData[1].getAge());
        values.put(MEMBER_2_KEY_RELATION_TO_OWNER, familyData[1].getRelationToOwner());
        values.put(MEMBER_2_KEY_LEAVE_HOME_6MONTH, familyData[1].getHasLeftHome6Month());
        values.put(MEMBER_2_KEY_LEAVE_HOME_REASON, familyData[1].getLeaveHome_reason());
        values.put(MEMBER_2_KEY_EDUCATION, familyData[1].getEducation());
        values.put(MEMBER_2_KEY_SCHOOL_TYPE, familyData[1].getSchoolType());
        values.put(MEMBER_2_KEY_LEAVE_SCHOOL_REASON, familyData[1].getLeaveSchool_reason());
        values.put(MEMBER_2_KEY_INCOME_SOURCE, familyData[1].getIncomeSource());
        values.put(MEMBER_2_KEY_ABROAD_COUNTRY, familyData[1].getAbroad_country());
        values.put(MEMBER_2_KEY_ABROAD_MONEYTRANSFER, familyData[1].getAbroad_moneyTransfer());
        values.put(MEMBER_2_KEY_SKILLS, familyData[1].getSkills());
        values.put(MEMBER_2_KEY_REGULARDEPOSIT, familyData[1].getRegularDeposit());
        values.put(MEMBER_2_KEY_REGULARDEPOSIT_TO, familyData[1].getRegularDeposit_to());
        values.put(MEMBER_2_KEY_USESVACCINE, familyData[1].getUsesVaccine());
        values.put(MEMBER_2_KEY_SOCIALINVOLVEMENTS, familyData[1].getSocialInvolvements());
        values.put(MEMBER_2_KEY_HASRECEIVEDTRAINING, familyData[1].getHasReceivedTraining());
        values.put(MEMBER_2_KEY_TRAININGLIST, familyData[1].getTrainingList());
        values.put(MEMBER_2_KEY_TRAVELWORK, familyData[1].getTravelWork());
        values.put(MEMBER_2_KEY_TRAVELWORKTO, familyData[1].getTravelWorkTo());
        values.put(MEMBER_2_KEY_TRAVELBUSINESS, familyData[1].getTravelBusiness());
        values.put(MEMBER_2_KEY_TRAVELBUSINESSTO, familyData[1].getTravelBusinessTo());
        values.put(MEMBER_2_KEY_TRAVELEDUCATION, familyData[1].getTravelEducation());
        values.put(MEMBER_2_KEY_TRAVELEDUCATIONTO, familyData[1].getTravelEducationTo());
        values.put(MEMBER_2_KEY_TRAVELOTHERS, familyData[1].getTravelOthers());
        values.put(MEMBER_2_KEY_TRAVELOTHERSTO, familyData[1].getTravelOthersTo());

        values.put(MEMBER_3_KEY_NAME_THAR, familyData[2].getName());
        values.put(MEMBER_3_KEY_GENDER, familyData[2].getGender());
        values.put(MEMBER_3_KEY_AGE, familyData[2].getAge());
        values.put(MEMBER_3_KEY_RELATION_TO_OWNER, familyData[2].getRelationToOwner());
        values.put(MEMBER_3_KEY_LEAVE_HOME_6MONTH, familyData[2].getHasLeftHome6Month());
        values.put(MEMBER_3_KEY_LEAVE_HOME_REASON, familyData[2].getLeaveHome_reason());
        values.put(MEMBER_3_KEY_EDUCATION, familyData[2].getEducation());
        values.put(MEMBER_3_KEY_SCHOOL_TYPE, familyData[2].getSchoolType());
        values.put(MEMBER_3_KEY_LEAVE_SCHOOL_REASON, familyData[2].getLeaveSchool_reason());
        values.put(MEMBER_3_KEY_INCOME_SOURCE, familyData[2].getIncomeSource());
        values.put(MEMBER_3_KEY_ABROAD_COUNTRY, familyData[2].getAbroad_country());
        values.put(MEMBER_3_KEY_ABROAD_MONEYTRANSFER, familyData[2].getAbroad_moneyTransfer());
        values.put(MEMBER_3_KEY_SKILLS, familyData[2].getSkills());
        values.put(MEMBER_3_KEY_REGULARDEPOSIT, familyData[2].getRegularDeposit());
        values.put(MEMBER_3_KEY_REGULARDEPOSIT_TO, familyData[2].getRegularDeposit_to());
        values.put(MEMBER_3_KEY_USESVACCINE, familyData[2].getUsesVaccine());
        values.put(MEMBER_3_KEY_SOCIALINVOLVEMENTS, familyData[2].getSocialInvolvements());
        values.put(MEMBER_3_KEY_HASRECEIVEDTRAINING, familyData[2].getHasReceivedTraining());
        values.put(MEMBER_3_KEY_TRAININGLIST, familyData[2].getTrainingList());
        values.put(MEMBER_3_KEY_TRAVELWORK, familyData[2].getTravelWork());
        values.put(MEMBER_3_KEY_TRAVELWORKTO, familyData[2].getTravelWorkTo());
        values.put(MEMBER_3_KEY_TRAVELBUSINESS, familyData[2].getTravelBusiness());
        values.put(MEMBER_3_KEY_TRAVELBUSINESSTO, familyData[2].getTravelBusinessTo());
        values.put(MEMBER_3_KEY_TRAVELEDUCATION, familyData[2].getTravelEducation());
        values.put(MEMBER_3_KEY_TRAVELEDUCATIONTO, familyData[2].getTravelEducationTo());
        values.put(MEMBER_3_KEY_TRAVELOTHERS, familyData[2].getTravelOthers());
        values.put(MEMBER_3_KEY_TRAVELOTHERSTO, familyData[2].getTravelOthersTo());


        values.put(MEMBER_4_KEY_NAME_THAR, familyData[3].getName());
        values.put(MEMBER_4_KEY_GENDER, familyData[3].getGender());
        values.put(MEMBER_4_KEY_AGE, familyData[3].getAge());
        values.put(MEMBER_4_KEY_RELATION_TO_OWNER, familyData[3].getRelationToOwner());
        values.put(MEMBER_4_KEY_LEAVE_HOME_6MONTH, familyData[3].getHasLeftHome6Month());
        values.put(MEMBER_4_KEY_LEAVE_HOME_REASON, familyData[3].getLeaveHome_reason());
        values.put(MEMBER_4_KEY_EDUCATION, familyData[3].getEducation());
        values.put(MEMBER_4_KEY_SCHOOL_TYPE, familyData[3].getSchoolType());
        values.put(MEMBER_4_KEY_LEAVE_SCHOOL_REASON, familyData[3].getLeaveSchool_reason());
        values.put(MEMBER_4_KEY_INCOME_SOURCE, familyData[3].getIncomeSource());
        values.put(MEMBER_4_KEY_ABROAD_COUNTRY, familyData[3].getAbroad_country());
        values.put(MEMBER_4_KEY_ABROAD_MONEYTRANSFER, familyData[3].getAbroad_moneyTransfer());
        values.put(MEMBER_4_KEY_SKILLS, familyData[3].getSkills());
        values.put(MEMBER_4_KEY_REGULARDEPOSIT, familyData[3].getRegularDeposit());
        values.put(MEMBER_4_KEY_REGULARDEPOSIT_TO, familyData[3].getRegularDeposit_to());
        values.put(MEMBER_4_KEY_USESVACCINE, familyData[3].getUsesVaccine());
        values.put(MEMBER_4_KEY_SOCIALINVOLVEMENTS, familyData[3].getSocialInvolvements());
        values.put(MEMBER_4_KEY_HASRECEIVEDTRAINING, familyData[3].getHasReceivedTraining());
        values.put(MEMBER_4_KEY_TRAININGLIST, familyData[3].getTrainingList());
        values.put(MEMBER_4_KEY_TRAVELWORK, familyData[3].getTravelWork());
        values.put(MEMBER_4_KEY_TRAVELWORKTO, familyData[3].getTravelWorkTo());
        values.put(MEMBER_4_KEY_TRAVELBUSINESS, familyData[3].getTravelBusiness());
        values.put(MEMBER_4_KEY_TRAVELBUSINESSTO, familyData[3].getTravelBusinessTo());
        values.put(MEMBER_4_KEY_TRAVELEDUCATION, familyData[3].getTravelEducation());
        values.put(MEMBER_4_KEY_TRAVELEDUCATIONTO, familyData[3].getTravelEducationTo());
        values.put(MEMBER_4_KEY_TRAVELOTHERS, familyData[3].getTravelOthers());
        values.put(MEMBER_4_KEY_TRAVELOTHERSTO, familyData[3].getTravelOthersTo());


        values.put(MEMBER_5_KEY_NAME_THAR, familyData[4].getName());
        values.put(MEMBER_5_KEY_GENDER, familyData[4].getGender());
        values.put(MEMBER_5_KEY_AGE, familyData[4].getAge());
        values.put(MEMBER_5_KEY_RELATION_TO_OWNER, familyData[4].getRelationToOwner());
        values.put(MEMBER_5_KEY_LEAVE_HOME_6MONTH, familyData[4].getHasLeftHome6Month());
        values.put(MEMBER_5_KEY_LEAVE_HOME_REASON, familyData[4].getLeaveHome_reason());
        values.put(MEMBER_5_KEY_EDUCATION, familyData[4].getEducation());
        values.put(MEMBER_5_KEY_SCHOOL_TYPE, familyData[4].getSchoolType());
        values.put(MEMBER_5_KEY_LEAVE_SCHOOL_REASON, familyData[4].getLeaveSchool_reason());
        values.put(MEMBER_5_KEY_INCOME_SOURCE, familyData[4].getIncomeSource());
        values.put(MEMBER_5_KEY_ABROAD_COUNTRY, familyData[4].getAbroad_country());
        values.put(MEMBER_5_KEY_ABROAD_MONEYTRANSFER, familyData[4].getAbroad_moneyTransfer());
        values.put(MEMBER_5_KEY_SKILLS, familyData[4].getSkills());
        values.put(MEMBER_5_KEY_REGULARDEPOSIT, familyData[4].getRegularDeposit());
        values.put(MEMBER_5_KEY_REGULARDEPOSIT_TO, familyData[4].getRegularDeposit_to());
        values.put(MEMBER_5_KEY_USESVACCINE, familyData[4].getUsesVaccine());
        values.put(MEMBER_5_KEY_SOCIALINVOLVEMENTS, familyData[4].getSocialInvolvements());
        values.put(MEMBER_5_KEY_HASRECEIVEDTRAINING, familyData[4].getHasReceivedTraining());
        values.put(MEMBER_5_KEY_TRAININGLIST, familyData[4].getTrainingList());
        values.put(MEMBER_5_KEY_TRAVELWORK, familyData[4].getTravelWork());
        values.put(MEMBER_5_KEY_TRAVELWORKTO, familyData[4].getTravelWorkTo());
        values.put(MEMBER_5_KEY_TRAVELBUSINESS, familyData[4].getTravelBusiness());
        values.put(MEMBER_5_KEY_TRAVELBUSINESSTO, familyData[4].getTravelBusinessTo());
        values.put(MEMBER_5_KEY_TRAVELEDUCATION, familyData[4].getTravelEducation());
        values.put(MEMBER_5_KEY_TRAVELEDUCATIONTO, familyData[4].getTravelEducationTo());
        values.put(MEMBER_5_KEY_TRAVELOTHERS, familyData[4].getTravelOthers());
        values.put(MEMBER_5_KEY_TRAVELOTHERSTO, familyData[4].getTravelOthersTo());


        values.put(MEMBER_6_KEY_NAME_THAR, familyData[5].getName());
        values.put(MEMBER_6_KEY_GENDER, familyData[5].getGender());
        values.put(MEMBER_6_KEY_AGE, familyData[5].getAge());
        values.put(MEMBER_6_KEY_RELATION_TO_OWNER, familyData[5].getRelationToOwner());
        values.put(MEMBER_6_KEY_LEAVE_HOME_6MONTH, familyData[5].getHasLeftHome6Month());
        values.put(MEMBER_6_KEY_LEAVE_HOME_REASON, familyData[5].getLeaveHome_reason());
        values.put(MEMBER_6_KEY_EDUCATION, familyData[5].getEducation());
        values.put(MEMBER_6_KEY_SCHOOL_TYPE, familyData[5].getSchoolType());
        values.put(MEMBER_6_KEY_LEAVE_SCHOOL_REASON, familyData[5].getLeaveSchool_reason());
        values.put(MEMBER_6_KEY_INCOME_SOURCE, familyData[5].getIncomeSource());
        values.put(MEMBER_6_KEY_ABROAD_COUNTRY, familyData[5].getAbroad_country());
        values.put(MEMBER_6_KEY_ABROAD_MONEYTRANSFER, familyData[5].getAbroad_moneyTransfer());
        values.put(MEMBER_6_KEY_SKILLS, familyData[5].getSkills());
        values.put(MEMBER_6_KEY_REGULARDEPOSIT, familyData[5].getRegularDeposit());
        values.put(MEMBER_6_KEY_REGULARDEPOSIT_TO, familyData[5].getRegularDeposit_to());
        values.put(MEMBER_6_KEY_USESVACCINE, familyData[5].getUsesVaccine());
        values.put(MEMBER_6_KEY_SOCIALINVOLVEMENTS, familyData[5].getSocialInvolvements());
        values.put(MEMBER_6_KEY_HASRECEIVEDTRAINING, familyData[5].getHasReceivedTraining());
        values.put(MEMBER_6_KEY_TRAININGLIST, familyData[5].getTrainingList());
        values.put(MEMBER_6_KEY_TRAVELWORK, familyData[5].getTravelWork());
        values.put(MEMBER_6_KEY_TRAVELWORKTO, familyData[5].getTravelWorkTo());
        values.put(MEMBER_6_KEY_TRAVELBUSINESS, familyData[5].getTravelBusiness());
        values.put(MEMBER_6_KEY_TRAVELBUSINESSTO, familyData[5].getTravelBusinessTo());
        values.put(MEMBER_6_KEY_TRAVELEDUCATION, familyData[5].getTravelEducation());
        values.put(MEMBER_6_KEY_TRAVELEDUCATIONTO, familyData[5].getTravelEducationTo());
        values.put(MEMBER_6_KEY_TRAVELOTHERS, familyData[5].getTravelOthers());
        values.put(MEMBER_6_KEY_TRAVELOTHERSTO, familyData[5].getTravelOthersTo());


        values.put(MEMBER_7_KEY_NAME_THAR, familyData[6].getName());
        values.put(MEMBER_7_KEY_GENDER, familyData[6].getGender());
        values.put(MEMBER_7_KEY_AGE, familyData[6].getAge());
        values.put(MEMBER_7_KEY_RELATION_TO_OWNER, familyData[6].getRelationToOwner());
        values.put(MEMBER_7_KEY_LEAVE_HOME_6MONTH, familyData[6].getHasLeftHome6Month());
        values.put(MEMBER_7_KEY_LEAVE_HOME_REASON, familyData[6].getLeaveHome_reason());
        values.put(MEMBER_7_KEY_EDUCATION, familyData[6].getEducation());
        values.put(MEMBER_7_KEY_SCHOOL_TYPE, familyData[6].getSchoolType());
        values.put(MEMBER_7_KEY_LEAVE_SCHOOL_REASON, familyData[6].getLeaveSchool_reason());
        values.put(MEMBER_7_KEY_INCOME_SOURCE, familyData[6].getIncomeSource());
        values.put(MEMBER_7_KEY_ABROAD_COUNTRY, familyData[6].getAbroad_country());
        values.put(MEMBER_7_KEY_ABROAD_MONEYTRANSFER, familyData[6].getAbroad_moneyTransfer());
        values.put(MEMBER_7_KEY_SKILLS, familyData[6].getSkills());
        values.put(MEMBER_7_KEY_REGULARDEPOSIT, familyData[6].getRegularDeposit());
        values.put(MEMBER_7_KEY_REGULARDEPOSIT_TO, familyData[6].getRegularDeposit_to());
        values.put(MEMBER_7_KEY_USESVACCINE, familyData[6].getUsesVaccine());
        values.put(MEMBER_7_KEY_SOCIALINVOLVEMENTS, familyData[6].getSocialInvolvements());
        values.put(MEMBER_7_KEY_HASRECEIVEDTRAINING, familyData[6].getHasReceivedTraining());
        values.put(MEMBER_7_KEY_TRAININGLIST, familyData[6].getTrainingList());
        values.put(MEMBER_7_KEY_TRAVELWORK, familyData[6].getTravelWork());
        values.put(MEMBER_7_KEY_TRAVELWORKTO, familyData[6].getTravelWorkTo());
        values.put(MEMBER_7_KEY_TRAVELBUSINESS, familyData[6].getTravelBusiness());
        values.put(MEMBER_7_KEY_TRAVELBUSINESSTO, familyData[6].getTravelBusinessTo());
        values.put(MEMBER_7_KEY_TRAVELEDUCATION, familyData[6].getTravelEducation());
        values.put(MEMBER_7_KEY_TRAVELEDUCATIONTO, familyData[6].getTravelEducationTo());
        values.put(MEMBER_7_KEY_TRAVELOTHERS, familyData[6].getTravelOthers());
        values.put(MEMBER_7_KEY_TRAVELOTHERSTO, familyData[6].getTravelOthersTo());


        values.put(MEMBER_8_KEY_NAME_THAR, familyData[7].getName());
        values.put(MEMBER_8_KEY_GENDER, familyData[7].getGender());
        values.put(MEMBER_8_KEY_AGE, familyData[7].getAge());
        values.put(MEMBER_8_KEY_RELATION_TO_OWNER, familyData[7].getRelationToOwner());
        values.put(MEMBER_8_KEY_LEAVE_HOME_6MONTH, familyData[7].getHasLeftHome6Month());
        values.put(MEMBER_8_KEY_LEAVE_HOME_REASON, familyData[7].getLeaveHome_reason());
        values.put(MEMBER_8_KEY_EDUCATION, familyData[7].getEducation());
        values.put(MEMBER_8_KEY_SCHOOL_TYPE, familyData[7].getSchoolType());
        values.put(MEMBER_8_KEY_LEAVE_SCHOOL_REASON, familyData[7].getLeaveSchool_reason());
        values.put(MEMBER_8_KEY_INCOME_SOURCE, familyData[7].getIncomeSource());
        values.put(MEMBER_8_KEY_ABROAD_COUNTRY, familyData[7].getAbroad_country());
        values.put(MEMBER_8_KEY_ABROAD_MONEYTRANSFER, familyData[7].getAbroad_moneyTransfer());
        values.put(MEMBER_8_KEY_SKILLS, familyData[7].getSkills());
        values.put(MEMBER_8_KEY_REGULARDEPOSIT, familyData[7].getRegularDeposit());
        values.put(MEMBER_8_KEY_REGULARDEPOSIT_TO, familyData[7].getRegularDeposit_to());
        values.put(MEMBER_8_KEY_USESVACCINE, familyData[7].getUsesVaccine());
        values.put(MEMBER_8_KEY_SOCIALINVOLVEMENTS, familyData[7].getSocialInvolvements());
        values.put(MEMBER_8_KEY_HASRECEIVEDTRAINING, familyData[7].getHasReceivedTraining());
        values.put(MEMBER_8_KEY_TRAININGLIST, familyData[7].getTrainingList());
        values.put(MEMBER_8_KEY_TRAVELWORK, familyData[7].getTravelWork());
        values.put(MEMBER_8_KEY_TRAVELWORKTO, familyData[7].getTravelWorkTo());
        values.put(MEMBER_8_KEY_TRAVELBUSINESS, familyData[7].getTravelBusiness());
        values.put(MEMBER_8_KEY_TRAVELBUSINESSTO, familyData[7].getTravelBusinessTo());
        values.put(MEMBER_8_KEY_TRAVELEDUCATION, familyData[7].getTravelEducation());
        values.put(MEMBER_8_KEY_TRAVELEDUCATIONTO, familyData[7].getTravelEducationTo());
        values.put(MEMBER_8_KEY_TRAVELOTHERS, familyData[7].getTravelOthers());
        values.put(MEMBER_8_KEY_TRAVELOTHERSTO, familyData[7].getTravelOthersTo());

        values.put(MEMBER_9_KEY_NAME_THAR, familyData[8].getName());
        values.put(MEMBER_9_KEY_GENDER, familyData[8].getGender());
        values.put(MEMBER_9_KEY_AGE, familyData[8].getAge());
        values.put(MEMBER_9_KEY_RELATION_TO_OWNER, familyData[8].getRelationToOwner());
        values.put(MEMBER_9_KEY_LEAVE_HOME_6MONTH, familyData[8].getHasLeftHome6Month());
        values.put(MEMBER_9_KEY_LEAVE_HOME_REASON, familyData[8].getLeaveHome_reason());
        values.put(MEMBER_9_KEY_EDUCATION, familyData[8].getEducation());
        values.put(MEMBER_9_KEY_SCHOOL_TYPE, familyData[8].getSchoolType());
        values.put(MEMBER_9_KEY_LEAVE_SCHOOL_REASON, familyData[8].getLeaveSchool_reason());
        values.put(MEMBER_9_KEY_INCOME_SOURCE, familyData[8].getIncomeSource());
        values.put(MEMBER_9_KEY_ABROAD_COUNTRY, familyData[8].getAbroad_country());
        values.put(MEMBER_9_KEY_ABROAD_MONEYTRANSFER, familyData[8].getAbroad_moneyTransfer());
        values.put(MEMBER_9_KEY_SKILLS, familyData[8].getSkills());
        values.put(MEMBER_9_KEY_REGULARDEPOSIT, familyData[8].getRegularDeposit());
        values.put(MEMBER_9_KEY_REGULARDEPOSIT_TO, familyData[8].getRegularDeposit_to());
        values.put(MEMBER_9_KEY_USESVACCINE, familyData[8].getUsesVaccine());
        values.put(MEMBER_9_KEY_SOCIALINVOLVEMENTS, familyData[8].getSocialInvolvements());
        values.put(MEMBER_9_KEY_HASRECEIVEDTRAINING, familyData[8].getHasReceivedTraining());
        values.put(MEMBER_9_KEY_TRAININGLIST, familyData[8].getTrainingList());
        values.put(MEMBER_9_KEY_TRAVELWORK, familyData[8].getTravelWork());
        values.put(MEMBER_9_KEY_TRAVELWORKTO, familyData[8].getTravelWorkTo());
        values.put(MEMBER_9_KEY_TRAVELBUSINESS, familyData[8].getTravelBusiness());
        values.put(MEMBER_9_KEY_TRAVELBUSINESSTO, familyData[8].getTravelBusinessTo());
        values.put(MEMBER_9_KEY_TRAVELEDUCATION, familyData[8].getTravelEducation());
        values.put(MEMBER_9_KEY_TRAVELEDUCATIONTO, familyData[8].getTravelEducationTo());
        values.put(MEMBER_9_KEY_TRAVELOTHERS, familyData[8].getTravelOthers());
        values.put(MEMBER_9_KEY_TRAVELOTHERSTO, familyData[8].getTravelOthersTo());

        values.put(MEMBER_10_KEY_NAME_THAR, familyData[9].getName());
        values.put(MEMBER_10_KEY_GENDER, familyData[9].getGender());
        values.put(MEMBER_10_KEY_AGE, familyData[9].getAge());
        values.put(MEMBER_10_KEY_RELATION_TO_OWNER, familyData[9].getRelationToOwner());
        values.put(MEMBER_10_KEY_LEAVE_HOME_6MONTH, familyData[9].getHasLeftHome6Month());
        values.put(MEMBER_10_KEY_LEAVE_HOME_REASON, familyData[9].getLeaveHome_reason());
        values.put(MEMBER_10_KEY_EDUCATION, familyData[9].getEducation());
        values.put(MEMBER_10_KEY_SCHOOL_TYPE, familyData[9].getSchoolType());
        values.put(MEMBER_10_KEY_LEAVE_SCHOOL_REASON, familyData[9].getLeaveSchool_reason());
        values.put(MEMBER_10_KEY_INCOME_SOURCE, familyData[9].getIncomeSource());
        values.put(MEMBER_10_KEY_ABROAD_COUNTRY, familyData[9].getAbroad_country());
        values.put(MEMBER_10_KEY_ABROAD_MONEYTRANSFER, familyData[9].getAbroad_moneyTransfer());
        values.put(MEMBER_10_KEY_SKILLS, familyData[9].getSkills());
        values.put(MEMBER_10_KEY_REGULARDEPOSIT, familyData[9].getRegularDeposit());
        values.put(MEMBER_10_KEY_REGULARDEPOSIT_TO, familyData[9].getRegularDeposit_to());
        values.put(MEMBER_10_KEY_USESVACCINE, familyData[9].getUsesVaccine());
        values.put(MEMBER_10_KEY_SOCIALINVOLVEMENTS, familyData[9].getSocialInvolvements());
        values.put(MEMBER_10_KEY_HASRECEIVEDTRAINING, familyData[9].getHasReceivedTraining());
        values.put(MEMBER_10_KEY_TRAININGLIST, familyData[9].getTrainingList());
        values.put(MEMBER_10_KEY_TRAVELWORK, familyData[9].getTravelWork());
        values.put(MEMBER_10_KEY_TRAVELWORKTO, familyData[9].getTravelWorkTo());
        values.put(MEMBER_10_KEY_TRAVELBUSINESS, familyData[9].getTravelBusiness());
        values.put(MEMBER_10_KEY_TRAVELBUSINESSTO, familyData[9].getTravelBusinessTo());
        values.put(MEMBER_10_KEY_TRAVELEDUCATION, familyData[9].getTravelEducation());
        values.put(MEMBER_10_KEY_TRAVELEDUCATIONTO, familyData[9].getTravelEducationTo());
        values.put(MEMBER_10_KEY_TRAVELOTHERS, familyData[9].getTravelOthers());
        values.put(MEMBER_10_KEY_TRAVELOTHERSTO, familyData[9].getTravelOthersTo());


        values.put(MEMBER_11_KEY_NAME_THAR, familyData[10].getName());
        values.put(MEMBER_11_KEY_GENDER, familyData[10].getGender());
        values.put(MEMBER_11_KEY_AGE, familyData[10].getAge());
        values.put(MEMBER_11_KEY_RELATION_TO_OWNER, familyData[10].getRelationToOwner());
        values.put(MEMBER_11_KEY_LEAVE_HOME_6MONTH, familyData[10].getHasLeftHome6Month());
        values.put(MEMBER_11_KEY_LEAVE_HOME_REASON, familyData[10].getLeaveHome_reason());
        values.put(MEMBER_11_KEY_EDUCATION, familyData[10].getEducation());
        values.put(MEMBER_11_KEY_SCHOOL_TYPE, familyData[10].getSchoolType());
        values.put(MEMBER_11_KEY_LEAVE_SCHOOL_REASON, familyData[10].getLeaveSchool_reason());
        values.put(MEMBER_11_KEY_INCOME_SOURCE, familyData[10].getIncomeSource());
        values.put(MEMBER_11_KEY_ABROAD_COUNTRY, familyData[10].getAbroad_country());
        values.put(MEMBER_11_KEY_ABROAD_MONEYTRANSFER, familyData[10].getAbroad_moneyTransfer());
        values.put(MEMBER_11_KEY_SKILLS, familyData[10].getSkills());
        values.put(MEMBER_11_KEY_REGULARDEPOSIT, familyData[10].getRegularDeposit());
        values.put(MEMBER_11_KEY_REGULARDEPOSIT_TO, familyData[10].getRegularDeposit_to());
        values.put(MEMBER_11_KEY_USESVACCINE, familyData[10].getUsesVaccine());
        values.put(MEMBER_11_KEY_SOCIALINVOLVEMENTS, familyData[10].getSocialInvolvements());
        values.put(MEMBER_11_KEY_HASRECEIVEDTRAINING, familyData[10].getHasReceivedTraining());
        values.put(MEMBER_11_KEY_TRAININGLIST, familyData[10].getTrainingList());
        values.put(MEMBER_11_KEY_TRAVELWORK, familyData[10].getTravelWork());
        values.put(MEMBER_11_KEY_TRAVELWORKTO, familyData[10].getTravelWorkTo());
        values.put(MEMBER_11_KEY_TRAVELBUSINESS, familyData[10].getTravelBusiness());
        values.put(MEMBER_11_KEY_TRAVELBUSINESSTO, familyData[10].getTravelBusinessTo());
        values.put(MEMBER_11_KEY_TRAVELEDUCATION, familyData[10].getTravelEducation());
        values.put(MEMBER_11_KEY_TRAVELEDUCATIONTO, familyData[10].getTravelEducationTo());
        values.put(MEMBER_11_KEY_TRAVELOTHERS, familyData[10].getTravelOthers());
        values.put(MEMBER_11_KEY_TRAVELOTHERSTO, familyData[10].getTravelOthersTo());

        values.put(MEMBER_12_KEY_NAME_THAR, familyData[11].getName());
        values.put(MEMBER_12_KEY_GENDER, familyData[11].getGender());
        values.put(MEMBER_12_KEY_AGE, familyData[11].getAge());
        values.put(MEMBER_12_KEY_RELATION_TO_OWNER, familyData[11].getRelationToOwner());
        values.put(MEMBER_12_KEY_LEAVE_HOME_6MONTH, familyData[11].getHasLeftHome6Month());
        values.put(MEMBER_12_KEY_LEAVE_HOME_REASON, familyData[11].getLeaveHome_reason());
        values.put(MEMBER_12_KEY_EDUCATION, familyData[11].getEducation());
        values.put(MEMBER_12_KEY_SCHOOL_TYPE, familyData[11].getSchoolType());
        values.put(MEMBER_12_KEY_LEAVE_SCHOOL_REASON, familyData[11].getLeaveSchool_reason());
        values.put(MEMBER_12_KEY_INCOME_SOURCE, familyData[11].getIncomeSource());
        values.put(MEMBER_12_KEY_ABROAD_COUNTRY, familyData[11].getAbroad_country());
        values.put(MEMBER_12_KEY_ABROAD_MONEYTRANSFER, familyData[11].getAbroad_moneyTransfer());
        values.put(MEMBER_12_KEY_SKILLS, familyData[11].getSkills());
        values.put(MEMBER_12_KEY_REGULARDEPOSIT, familyData[11].getRegularDeposit());
        values.put(MEMBER_12_KEY_REGULARDEPOSIT_TO, familyData[11].getRegularDeposit_to());
        values.put(MEMBER_12_KEY_USESVACCINE, familyData[11].getUsesVaccine());
        values.put(MEMBER_12_KEY_SOCIALINVOLVEMENTS, familyData[11].getSocialInvolvements());
        values.put(MEMBER_12_KEY_HASRECEIVEDTRAINING, familyData[11].getHasReceivedTraining());
        values.put(MEMBER_12_KEY_TRAININGLIST, familyData[11].getTrainingList());
        values.put(MEMBER_12_KEY_TRAVELWORK, familyData[11].getTravelWork());
        values.put(MEMBER_12_KEY_TRAVELWORKTO, familyData[11].getTravelWorkTo());
        values.put(MEMBER_12_KEY_TRAVELBUSINESS, familyData[11].getTravelBusiness());
        values.put(MEMBER_12_KEY_TRAVELBUSINESSTO, familyData[11].getTravelBusinessTo());
        values.put(MEMBER_12_KEY_TRAVELEDUCATION, familyData[11].getTravelEducation());
        values.put(MEMBER_12_KEY_TRAVELEDUCATIONTO, familyData[11].getTravelEducationTo());
        values.put(MEMBER_12_KEY_TRAVELOTHERS, familyData[11].getTravelOthers());
        values.put(MEMBER_12_KEY_TRAVELOTHERSTO, familyData[11].getTravelOthersTo());

        values.put(MEMBER_13_KEY_NAME_THAR, familyData[12].getName());
        values.put(MEMBER_13_KEY_GENDER, familyData[12].getGender());
        values.put(MEMBER_13_KEY_AGE, familyData[12].getAge());
        values.put(MEMBER_13_KEY_RELATION_TO_OWNER, familyData[12].getRelationToOwner());
        values.put(MEMBER_13_KEY_LEAVE_HOME_6MONTH, familyData[12].getHasLeftHome6Month());
        values.put(MEMBER_13_KEY_LEAVE_HOME_REASON, familyData[12].getLeaveHome_reason());
        values.put(MEMBER_13_KEY_EDUCATION, familyData[12].getEducation());
        values.put(MEMBER_13_KEY_SCHOOL_TYPE, familyData[12].getSchoolType());
        values.put(MEMBER_13_KEY_LEAVE_SCHOOL_REASON, familyData[12].getLeaveSchool_reason());
        values.put(MEMBER_13_KEY_INCOME_SOURCE, familyData[12].getIncomeSource());
        values.put(MEMBER_13_KEY_ABROAD_COUNTRY, familyData[12].getAbroad_country());
        values.put(MEMBER_13_KEY_ABROAD_MONEYTRANSFER, familyData[12].getAbroad_moneyTransfer());
        values.put(MEMBER_13_KEY_SKILLS, familyData[12].getSkills());
        values.put(MEMBER_13_KEY_REGULARDEPOSIT, familyData[12].getRegularDeposit());
        values.put(MEMBER_13_KEY_REGULARDEPOSIT_TO, familyData[12].getRegularDeposit_to());
        values.put(MEMBER_13_KEY_USESVACCINE, familyData[12].getUsesVaccine());
        values.put(MEMBER_13_KEY_SOCIALINVOLVEMENTS, familyData[12].getSocialInvolvements());
        values.put(MEMBER_13_KEY_HASRECEIVEDTRAINING, familyData[12].getHasReceivedTraining());
        values.put(MEMBER_13_KEY_TRAININGLIST, familyData[12].getTrainingList());
        values.put(MEMBER_13_KEY_TRAVELWORK, familyData[12].getTravelWork());
        values.put(MEMBER_13_KEY_TRAVELWORKTO, familyData[12].getTravelWorkTo());
        values.put(MEMBER_13_KEY_TRAVELBUSINESS, familyData[12].getTravelBusiness());
        values.put(MEMBER_13_KEY_TRAVELBUSINESSTO, familyData[12].getTravelBusinessTo());
        values.put(MEMBER_13_KEY_TRAVELEDUCATION, familyData[12].getTravelEducation());
        values.put(MEMBER_13_KEY_TRAVELEDUCATIONTO, familyData[12].getTravelEducationTo());
        values.put(MEMBER_13_KEY_TRAVELOTHERS, familyData[12].getTravelOthers());
        values.put(MEMBER_13_KEY_TRAVELOTHERSTO, familyData[12].getTravelOthersTo());

        values.put(MEMBER_14_KEY_NAME_THAR, familyData[13].getName());
        values.put(MEMBER_14_KEY_GENDER, familyData[13].getGender());
        values.put(MEMBER_14_KEY_AGE, familyData[13].getAge());
        values.put(MEMBER_14_KEY_RELATION_TO_OWNER, familyData[13].getRelationToOwner());
        values.put(MEMBER_14_KEY_LEAVE_HOME_6MONTH, familyData[13].getHasLeftHome6Month());
        values.put(MEMBER_14_KEY_LEAVE_HOME_REASON, familyData[13].getLeaveHome_reason());
        values.put(MEMBER_14_KEY_EDUCATION, familyData[13].getEducation());
        values.put(MEMBER_14_KEY_SCHOOL_TYPE, familyData[13].getSchoolType());
        values.put(MEMBER_14_KEY_LEAVE_SCHOOL_REASON, familyData[13].getLeaveSchool_reason());
        values.put(MEMBER_14_KEY_INCOME_SOURCE, familyData[13].getIncomeSource());
        values.put(MEMBER_14_KEY_ABROAD_COUNTRY, familyData[13].getAbroad_country());
        values.put(MEMBER_14_KEY_ABROAD_MONEYTRANSFER, familyData[13].getAbroad_moneyTransfer());
        values.put(MEMBER_14_KEY_SKILLS, familyData[13].getSkills());
        values.put(MEMBER_14_KEY_REGULARDEPOSIT, familyData[13].getRegularDeposit());
        values.put(MEMBER_14_KEY_REGULARDEPOSIT_TO, familyData[13].getRegularDeposit_to());
        values.put(MEMBER_14_KEY_USESVACCINE, familyData[13].getUsesVaccine());
        values.put(MEMBER_14_KEY_SOCIALINVOLVEMENTS, familyData[13].getSocialInvolvements());
        values.put(MEMBER_14_KEY_HASRECEIVEDTRAINING, familyData[13].getHasReceivedTraining());
        values.put(MEMBER_14_KEY_TRAININGLIST, familyData[13].getTrainingList());
        values.put(MEMBER_14_KEY_TRAVELWORK, familyData[13].getTravelWork());
        values.put(MEMBER_14_KEY_TRAVELWORKTO, familyData[13].getTravelWorkTo());
        values.put(MEMBER_14_KEY_TRAVELBUSINESS, familyData[13].getTravelBusiness());
        values.put(MEMBER_14_KEY_TRAVELBUSINESSTO, familyData[13].getTravelBusinessTo());
        values.put(MEMBER_14_KEY_TRAVELEDUCATION, familyData[13].getTravelEducation());
        values.put(MEMBER_14_KEY_TRAVELEDUCATIONTO, familyData[13].getTravelEducationTo());
        values.put(MEMBER_14_KEY_TRAVELOTHERS, familyData[13].getTravelOthers());
        values.put(MEMBER_14_KEY_TRAVELOTHERSTO, familyData[13].getTravelOthersTo());

        values.put(MEMBER_15_KEY_NAME_THAR, familyData[14].getName());
        values.put(MEMBER_15_KEY_GENDER, familyData[14].getGender());
        values.put(MEMBER_15_KEY_AGE, familyData[14].getAge());
        values.put(MEMBER_15_KEY_RELATION_TO_OWNER, familyData[14].getRelationToOwner());
        values.put(MEMBER_15_KEY_LEAVE_HOME_6MONTH, familyData[14].getHasLeftHome6Month());
        values.put(MEMBER_15_KEY_LEAVE_HOME_REASON, familyData[14].getLeaveHome_reason());
        values.put(MEMBER_15_KEY_EDUCATION, familyData[14].getEducation());
        values.put(MEMBER_15_KEY_SCHOOL_TYPE, familyData[14].getSchoolType());
        values.put(MEMBER_15_KEY_LEAVE_SCHOOL_REASON, familyData[14].getLeaveSchool_reason());
        values.put(MEMBER_15_KEY_INCOME_SOURCE, familyData[14].getIncomeSource());
        values.put(MEMBER_15_KEY_ABROAD_COUNTRY, familyData[14].getAbroad_country());
        values.put(MEMBER_15_KEY_ABROAD_MONEYTRANSFER, familyData[14].getAbroad_moneyTransfer());
        values.put(MEMBER_15_KEY_SKILLS, familyData[14].getSkills());
        values.put(MEMBER_15_KEY_REGULARDEPOSIT, familyData[14].getRegularDeposit());
        values.put(MEMBER_15_KEY_REGULARDEPOSIT_TO, familyData[14].getRegularDeposit_to());
        values.put(MEMBER_15_KEY_USESVACCINE, familyData[14].getUsesVaccine());
        values.put(MEMBER_15_KEY_SOCIALINVOLVEMENTS, familyData[14].getSocialInvolvements());
        values.put(MEMBER_15_KEY_HASRECEIVEDTRAINING, familyData[14].getHasReceivedTraining());
        values.put(MEMBER_15_KEY_TRAININGLIST, familyData[14].getTrainingList());
        values.put(MEMBER_15_KEY_TRAVELWORK, familyData[14].getTravelWork());
        values.put(MEMBER_15_KEY_TRAVELWORKTO, familyData[14].getTravelWorkTo());
        values.put(MEMBER_15_KEY_TRAVELBUSINESS, familyData[14].getTravelBusiness());
        values.put(MEMBER_15_KEY_TRAVELBUSINESSTO, familyData[14].getTravelBusinessTo());
        values.put(MEMBER_15_KEY_TRAVELEDUCATION, familyData[14].getTravelEducation());
        values.put(MEMBER_15_KEY_TRAVELEDUCATIONTO, familyData[14].getTravelEducationTo());
        values.put(MEMBER_15_KEY_TRAVELOTHERS, familyData[14].getTravelOthers());
        values.put(MEMBER_15_KEY_TRAVELOTHERSTO, familyData[14].getTravelOthersTo());

        values.put(MEMBER_16_KEY_NAME_THAR, familyData[15].getName());
        values.put(MEMBER_16_KEY_GENDER, familyData[15].getGender());
        values.put(MEMBER_16_KEY_AGE, familyData[15].getAge());
        values.put(MEMBER_16_KEY_RELATION_TO_OWNER, familyData[15].getRelationToOwner());
        values.put(MEMBER_16_KEY_LEAVE_HOME_6MONTH, familyData[15].getHasLeftHome6Month());
        values.put(MEMBER_16_KEY_LEAVE_HOME_REASON, familyData[15].getLeaveHome_reason());
        values.put(MEMBER_16_KEY_EDUCATION, familyData[15].getEducation());
        values.put(MEMBER_16_KEY_SCHOOL_TYPE, familyData[15].getSchoolType());
        values.put(MEMBER_16_KEY_LEAVE_SCHOOL_REASON, familyData[15].getLeaveSchool_reason());
        values.put(MEMBER_16_KEY_INCOME_SOURCE, familyData[15].getIncomeSource());
        values.put(MEMBER_16_KEY_ABROAD_COUNTRY, familyData[15].getAbroad_country());
        values.put(MEMBER_16_KEY_ABROAD_MONEYTRANSFER, familyData[15].getAbroad_moneyTransfer());
        values.put(MEMBER_16_KEY_SKILLS, familyData[15].getSkills());
        values.put(MEMBER_16_KEY_REGULARDEPOSIT, familyData[15].getRegularDeposit());
        values.put(MEMBER_16_KEY_REGULARDEPOSIT_TO, familyData[15].getRegularDeposit_to());
        values.put(MEMBER_16_KEY_USESVACCINE, familyData[15].getUsesVaccine());
        values.put(MEMBER_16_KEY_SOCIALINVOLVEMENTS, familyData[15].getSocialInvolvements());
        values.put(MEMBER_16_KEY_HASRECEIVEDTRAINING, familyData[15].getHasReceivedTraining());
        values.put(MEMBER_16_KEY_TRAININGLIST, familyData[15].getTrainingList());
        values.put(MEMBER_16_KEY_TRAVELWORK, familyData[15].getTravelWork());
        values.put(MEMBER_16_KEY_TRAVELWORKTO, familyData[15].getTravelWorkTo());
        values.put(MEMBER_16_KEY_TRAVELBUSINESS, familyData[15].getTravelBusiness());
        values.put(MEMBER_16_KEY_TRAVELBUSINESSTO, familyData[15].getTravelBusinessTo());
        values.put(MEMBER_16_KEY_TRAVELEDUCATION, familyData[15].getTravelEducation());
        values.put(MEMBER_16_KEY_TRAVELEDUCATIONTO, familyData[15].getTravelEducationTo());
        values.put(MEMBER_16_KEY_TRAVELOTHERS, familyData[15].getTravelOthers());
        values.put(MEMBER_16_KEY_TRAVELOTHERSTO, familyData[15].getTravelOthersTo());

        values.put(MEMBER_17_KEY_NAME_THAR, familyData[16].getName());
        values.put(MEMBER_17_KEY_GENDER, familyData[16].getGender());
        values.put(MEMBER_17_KEY_AGE, familyData[16].getAge());
        values.put(MEMBER_17_KEY_RELATION_TO_OWNER, familyData[16].getRelationToOwner());
        values.put(MEMBER_17_KEY_LEAVE_HOME_6MONTH, familyData[16].getHasLeftHome6Month());
        values.put(MEMBER_17_KEY_LEAVE_HOME_REASON, familyData[16].getLeaveHome_reason());
        values.put(MEMBER_17_KEY_EDUCATION, familyData[16].getEducation());
        values.put(MEMBER_17_KEY_SCHOOL_TYPE, familyData[16].getSchoolType());
        values.put(MEMBER_17_KEY_LEAVE_SCHOOL_REASON, familyData[16].getLeaveSchool_reason());
        values.put(MEMBER_17_KEY_INCOME_SOURCE, familyData[16].getIncomeSource());
        values.put(MEMBER_17_KEY_ABROAD_COUNTRY, familyData[16].getAbroad_country());
        values.put(MEMBER_17_KEY_ABROAD_MONEYTRANSFER, familyData[16].getAbroad_moneyTransfer());
        values.put(MEMBER_17_KEY_SKILLS, familyData[16].getSkills());
        values.put(MEMBER_17_KEY_REGULARDEPOSIT, familyData[16].getRegularDeposit());
        values.put(MEMBER_17_KEY_REGULARDEPOSIT_TO, familyData[16].getRegularDeposit_to());
        values.put(MEMBER_17_KEY_USESVACCINE, familyData[16].getUsesVaccine());
        values.put(MEMBER_17_KEY_SOCIALINVOLVEMENTS, familyData[16].getSocialInvolvements());
        values.put(MEMBER_17_KEY_HASRECEIVEDTRAINING, familyData[16].getHasReceivedTraining());
        values.put(MEMBER_17_KEY_TRAININGLIST, familyData[16].getTrainingList());
        values.put(MEMBER_17_KEY_TRAVELWORK, familyData[16].getTravelWork());
        values.put(MEMBER_17_KEY_TRAVELWORKTO, familyData[16].getTravelWorkTo());
        values.put(MEMBER_17_KEY_TRAVELBUSINESS, familyData[16].getTravelBusiness());
        values.put(MEMBER_17_KEY_TRAVELBUSINESSTO, familyData[16].getTravelBusinessTo());
        values.put(MEMBER_17_KEY_TRAVELEDUCATION, familyData[16].getTravelEducation());
        values.put(MEMBER_17_KEY_TRAVELEDUCATIONTO, familyData[16].getTravelEducationTo());
        values.put(MEMBER_17_KEY_TRAVELOTHERS, familyData[16].getTravelOthers());
        values.put(MEMBER_17_KEY_TRAVELOTHERSTO, familyData[16].getTravelOthersTo());

        values.put(MEMBER_18_KEY_NAME_THAR, familyData[17].getName());
        values.put(MEMBER_18_KEY_GENDER, familyData[17].getGender());
        values.put(MEMBER_18_KEY_AGE, familyData[17].getAge());
        values.put(MEMBER_18_KEY_RELATION_TO_OWNER, familyData[17].getRelationToOwner());
        values.put(MEMBER_18_KEY_LEAVE_HOME_6MONTH, familyData[17].getHasLeftHome6Month());
        values.put(MEMBER_18_KEY_LEAVE_HOME_REASON, familyData[17].getLeaveHome_reason());
        values.put(MEMBER_18_KEY_EDUCATION, familyData[17].getEducation());
        values.put(MEMBER_18_KEY_SCHOOL_TYPE, familyData[17].getSchoolType());
        values.put(MEMBER_18_KEY_LEAVE_SCHOOL_REASON, familyData[17].getLeaveSchool_reason());
        values.put(MEMBER_18_KEY_INCOME_SOURCE, familyData[17].getIncomeSource());
        values.put(MEMBER_18_KEY_ABROAD_COUNTRY, familyData[17].getAbroad_country());
        values.put(MEMBER_18_KEY_ABROAD_MONEYTRANSFER, familyData[17].getAbroad_moneyTransfer());
        values.put(MEMBER_18_KEY_SKILLS, familyData[17].getSkills());
        values.put(MEMBER_18_KEY_REGULARDEPOSIT, familyData[17].getRegularDeposit());
        values.put(MEMBER_18_KEY_REGULARDEPOSIT_TO, familyData[17].getRegularDeposit_to());
        values.put(MEMBER_18_KEY_USESVACCINE, familyData[17].getUsesVaccine());
        values.put(MEMBER_18_KEY_SOCIALINVOLVEMENTS, familyData[17].getSocialInvolvements());
        values.put(MEMBER_18_KEY_HASRECEIVEDTRAINING, familyData[17].getHasReceivedTraining());
        values.put(MEMBER_18_KEY_TRAININGLIST, familyData[17].getTrainingList());
        values.put(MEMBER_18_KEY_TRAVELWORK, familyData[17].getTravelWork());
        values.put(MEMBER_18_KEY_TRAVELWORKTO, familyData[17].getTravelWorkTo());
        values.put(MEMBER_18_KEY_TRAVELBUSINESS, familyData[17].getTravelBusiness());
        values.put(MEMBER_18_KEY_TRAVELBUSINESSTO, familyData[17].getTravelBusinessTo());
        values.put(MEMBER_18_KEY_TRAVELEDUCATION, familyData[17].getTravelEducation());
        values.put(MEMBER_18_KEY_TRAVELEDUCATIONTO, familyData[17].getTravelEducationTo());
        values.put(MEMBER_18_KEY_TRAVELOTHERS, familyData[17].getTravelOthers());
        values.put(MEMBER_18_KEY_TRAVELOTHERSTO, familyData[17].getTravelOthersTo());

        values.put(MEMBER_19_KEY_NAME_THAR, familyData[18].getName());
        values.put(MEMBER_19_KEY_GENDER, familyData[18].getGender());
        values.put(MEMBER_19_KEY_AGE, familyData[18].getAge());
        values.put(MEMBER_19_KEY_RELATION_TO_OWNER, familyData[18].getRelationToOwner());
        values.put(MEMBER_19_KEY_LEAVE_HOME_6MONTH, familyData[18].getHasLeftHome6Month());
        values.put(MEMBER_19_KEY_LEAVE_HOME_REASON, familyData[18].getLeaveHome_reason());
        values.put(MEMBER_19_KEY_EDUCATION, familyData[18].getEducation());
        values.put(MEMBER_19_KEY_SCHOOL_TYPE, familyData[18].getSchoolType());
        values.put(MEMBER_19_KEY_LEAVE_SCHOOL_REASON, familyData[18].getLeaveSchool_reason());
        values.put(MEMBER_19_KEY_INCOME_SOURCE, familyData[18].getIncomeSource());
        values.put(MEMBER_19_KEY_ABROAD_COUNTRY, familyData[18].getAbroad_country());
        values.put(MEMBER_19_KEY_ABROAD_MONEYTRANSFER, familyData[18].getAbroad_moneyTransfer());
        values.put(MEMBER_19_KEY_SKILLS, familyData[18].getSkills());
        values.put(MEMBER_19_KEY_REGULARDEPOSIT, familyData[18].getRegularDeposit());
        values.put(MEMBER_19_KEY_REGULARDEPOSIT_TO, familyData[18].getRegularDeposit_to());
        values.put(MEMBER_19_KEY_USESVACCINE, familyData[18].getUsesVaccine());
        values.put(MEMBER_19_KEY_SOCIALINVOLVEMENTS, familyData[18].getSocialInvolvements());
        values.put(MEMBER_19_KEY_HASRECEIVEDTRAINING, familyData[18].getHasReceivedTraining());
        values.put(MEMBER_19_KEY_TRAININGLIST, familyData[18].getTrainingList());
        values.put(MEMBER_19_KEY_TRAVELWORK, familyData[18].getTravelWork());
        values.put(MEMBER_19_KEY_TRAVELWORKTO, familyData[18].getTravelWorkTo());
        values.put(MEMBER_19_KEY_TRAVELBUSINESS, familyData[18].getTravelBusiness());
        values.put(MEMBER_19_KEY_TRAVELBUSINESSTO, familyData[18].getTravelBusinessTo());
        values.put(MEMBER_19_KEY_TRAVELEDUCATION, familyData[18].getTravelEducation());
        values.put(MEMBER_19_KEY_TRAVELEDUCATIONTO, familyData[18].getTravelEducationTo());
        values.put(MEMBER_19_KEY_TRAVELOTHERS, familyData[18].getTravelOthers());
        values.put(MEMBER_19_KEY_TRAVELOTHERSTO, familyData[18].getTravelOthersTo());

        values.put(MEMBER_20_KEY_NAME_THAR, familyData[19].getName());
        values.put(MEMBER_20_KEY_GENDER, familyData[19].getGender());
        values.put(MEMBER_20_KEY_AGE, familyData[19].getAge());
        values.put(MEMBER_20_KEY_RELATION_TO_OWNER, familyData[19].getRelationToOwner());
        values.put(MEMBER_20_KEY_LEAVE_HOME_6MONTH, familyData[19].getHasLeftHome6Month());
        values.put(MEMBER_20_KEY_LEAVE_HOME_REASON, familyData[19].getLeaveHome_reason());
        values.put(MEMBER_20_KEY_EDUCATION, familyData[19].getEducation());
        values.put(MEMBER_20_KEY_SCHOOL_TYPE, familyData[19].getSchoolType());
        values.put(MEMBER_20_KEY_LEAVE_SCHOOL_REASON, familyData[19].getLeaveSchool_reason());
        values.put(MEMBER_20_KEY_INCOME_SOURCE, familyData[19].getIncomeSource());
        values.put(MEMBER_20_KEY_ABROAD_COUNTRY, familyData[19].getAbroad_country());
        values.put(MEMBER_20_KEY_ABROAD_MONEYTRANSFER, familyData[19].getAbroad_moneyTransfer());
        values.put(MEMBER_20_KEY_SKILLS, familyData[19].getSkills());
        values.put(MEMBER_20_KEY_REGULARDEPOSIT, familyData[19].getRegularDeposit());
        values.put(MEMBER_20_KEY_REGULARDEPOSIT_TO, familyData[19].getRegularDeposit_to());
        values.put(MEMBER_20_KEY_USESVACCINE, familyData[19].getUsesVaccine());
        values.put(MEMBER_20_KEY_SOCIALINVOLVEMENTS, familyData[19].getSocialInvolvements());
        values.put(MEMBER_20_KEY_HASRECEIVEDTRAINING, familyData[19].getHasReceivedTraining());
        values.put(MEMBER_20_KEY_TRAININGLIST, familyData[19].getTrainingList());
        values.put(MEMBER_20_KEY_TRAVELWORK, familyData[19].getTravelWork());
        values.put(MEMBER_20_KEY_TRAVELWORKTO, familyData[19].getTravelWorkTo());
        values.put(MEMBER_20_KEY_TRAVELBUSINESS, familyData[19].getTravelBusiness());
        values.put(MEMBER_20_KEY_TRAVELBUSINESSTO, familyData[19].getTravelBusinessTo());
        values.put(MEMBER_20_KEY_TRAVELEDUCATION, familyData[19].getTravelEducation());
        values.put(MEMBER_20_KEY_TRAVELEDUCATIONTO, familyData[19].getTravelEducationTo());
        values.put(MEMBER_20_KEY_TRAVELOTHERS, familyData[19].getTravelOthers());
        values.put(MEMBER_20_KEY_TRAVELOTHERSTO, familyData[19].getTravelOthersTo());

        values.put(MEMBER_21_KEY_NAME_THAR, familyData[20].getName());
        values.put(MEMBER_21_KEY_GENDER, familyData[20].getGender());
        values.put(MEMBER_21_KEY_AGE, familyData[20].getAge());
        values.put(MEMBER_21_KEY_RELATION_TO_OWNER, familyData[20].getRelationToOwner());
        values.put(MEMBER_21_KEY_LEAVE_HOME_6MONTH, familyData[20].getHasLeftHome6Month());
        values.put(MEMBER_21_KEY_LEAVE_HOME_REASON, familyData[20].getLeaveHome_reason());
        values.put(MEMBER_21_KEY_EDUCATION, familyData[20].getEducation());
        values.put(MEMBER_21_KEY_SCHOOL_TYPE, familyData[20].getSchoolType());
        values.put(MEMBER_21_KEY_LEAVE_SCHOOL_REASON, familyData[20].getLeaveSchool_reason());
        values.put(MEMBER_21_KEY_INCOME_SOURCE, familyData[20].getIncomeSource());
        values.put(MEMBER_21_KEY_ABROAD_COUNTRY, familyData[20].getAbroad_country());
        values.put(MEMBER_21_KEY_ABROAD_MONEYTRANSFER, familyData[20].getAbroad_moneyTransfer());
        values.put(MEMBER_21_KEY_SKILLS, familyData[20].getSkills());
        values.put(MEMBER_21_KEY_REGULARDEPOSIT, familyData[20].getRegularDeposit());
        values.put(MEMBER_21_KEY_REGULARDEPOSIT_TO, familyData[20].getRegularDeposit_to());
        values.put(MEMBER_21_KEY_USESVACCINE, familyData[20].getUsesVaccine());
        values.put(MEMBER_21_KEY_SOCIALINVOLVEMENTS, familyData[20].getSocialInvolvements());
        values.put(MEMBER_21_KEY_HASRECEIVEDTRAINING, familyData[20].getHasReceivedTraining());
        values.put(MEMBER_21_KEY_TRAININGLIST, familyData[20].getTrainingList());
        values.put(MEMBER_21_KEY_TRAVELWORK, familyData[20].getTravelWork());
        values.put(MEMBER_21_KEY_TRAVELWORKTO, familyData[20].getTravelWorkTo());
        values.put(MEMBER_21_KEY_TRAVELBUSINESS, familyData[20].getTravelBusiness());
        values.put(MEMBER_21_KEY_TRAVELBUSINESSTO, familyData[20].getTravelBusinessTo());
        values.put(MEMBER_21_KEY_TRAVELEDUCATION, familyData[20].getTravelEducation());
        values.put(MEMBER_21_KEY_TRAVELEDUCATIONTO, familyData[20].getTravelEducationTo());
        values.put(MEMBER_21_KEY_TRAVELOTHERS, familyData[20].getTravelOthers());
        values.put(MEMBER_21_KEY_TRAVELOTHERSTO, familyData[20].getTravelOthersTo());

        values.put(MEMBER_22_KEY_NAME_THAR, familyData[21].getName());
        values.put(MEMBER_22_KEY_GENDER, familyData[21].getGender());
        values.put(MEMBER_22_KEY_AGE, familyData[21].getAge());
        values.put(MEMBER_22_KEY_RELATION_TO_OWNER, familyData[21].getRelationToOwner());
        values.put(MEMBER_22_KEY_LEAVE_HOME_6MONTH, familyData[21].getHasLeftHome6Month());
        values.put(MEMBER_22_KEY_LEAVE_HOME_REASON, familyData[21].getLeaveHome_reason());
        values.put(MEMBER_22_KEY_EDUCATION, familyData[21].getEducation());
        values.put(MEMBER_22_KEY_SCHOOL_TYPE, familyData[21].getSchoolType());
        values.put(MEMBER_22_KEY_LEAVE_SCHOOL_REASON, familyData[21].getLeaveSchool_reason());
        values.put(MEMBER_22_KEY_INCOME_SOURCE, familyData[21].getIncomeSource());
        values.put(MEMBER_22_KEY_ABROAD_COUNTRY, familyData[21].getAbroad_country());
        values.put(MEMBER_22_KEY_ABROAD_MONEYTRANSFER, familyData[21].getAbroad_moneyTransfer());
        values.put(MEMBER_22_KEY_SKILLS, familyData[21].getSkills());
        values.put(MEMBER_22_KEY_REGULARDEPOSIT, familyData[21].getRegularDeposit());
        values.put(MEMBER_22_KEY_REGULARDEPOSIT_TO, familyData[21].getRegularDeposit_to());
        values.put(MEMBER_22_KEY_USESVACCINE, familyData[21].getUsesVaccine());
        values.put(MEMBER_22_KEY_SOCIALINVOLVEMENTS, familyData[21].getSocialInvolvements());
        values.put(MEMBER_22_KEY_HASRECEIVEDTRAINING, familyData[21].getHasReceivedTraining());
        values.put(MEMBER_22_KEY_TRAININGLIST, familyData[21].getTrainingList());
        values.put(MEMBER_22_KEY_TRAVELWORK, familyData[21].getTravelWork());
        values.put(MEMBER_22_KEY_TRAVELWORKTO, familyData[21].getTravelWorkTo());
        values.put(MEMBER_22_KEY_TRAVELBUSINESS, familyData[21].getTravelBusiness());
        values.put(MEMBER_22_KEY_TRAVELBUSINESSTO, familyData[21].getTravelBusinessTo());
        values.put(MEMBER_22_KEY_TRAVELEDUCATION, familyData[21].getTravelEducation());
        values.put(MEMBER_22_KEY_TRAVELEDUCATIONTO, familyData[21].getTravelEducationTo());
        values.put(MEMBER_22_KEY_TRAVELOTHERS, familyData[21].getTravelOthers());
        values.put(MEMBER_22_KEY_TRAVELOTHERSTO, familyData[21].getTravelOthersTo());

        values.put(MEMBER_23_KEY_NAME_THAR, familyData[22].getName());
        values.put(MEMBER_23_KEY_GENDER, familyData[22].getGender());
        values.put(MEMBER_23_KEY_AGE, familyData[22].getAge());
        values.put(MEMBER_23_KEY_RELATION_TO_OWNER, familyData[22].getRelationToOwner());
        values.put(MEMBER_23_KEY_LEAVE_HOME_6MONTH, familyData[22].getHasLeftHome6Month());
        values.put(MEMBER_23_KEY_LEAVE_HOME_REASON, familyData[22].getLeaveHome_reason());
        values.put(MEMBER_23_KEY_EDUCATION, familyData[22].getEducation());
        values.put(MEMBER_23_KEY_SCHOOL_TYPE, familyData[22].getSchoolType());
        values.put(MEMBER_23_KEY_LEAVE_SCHOOL_REASON, familyData[22].getLeaveSchool_reason());
        values.put(MEMBER_23_KEY_INCOME_SOURCE, familyData[22].getIncomeSource());
        values.put(MEMBER_23_KEY_ABROAD_COUNTRY, familyData[22].getAbroad_country());
        values.put(MEMBER_23_KEY_ABROAD_MONEYTRANSFER, familyData[22].getAbroad_moneyTransfer());
        values.put(MEMBER_23_KEY_SKILLS, familyData[22].getSkills());
        values.put(MEMBER_23_KEY_REGULARDEPOSIT, familyData[22].getRegularDeposit());
        values.put(MEMBER_23_KEY_REGULARDEPOSIT_TO, familyData[22].getRegularDeposit_to());
        values.put(MEMBER_23_KEY_USESVACCINE, familyData[22].getUsesVaccine());
        values.put(MEMBER_23_KEY_SOCIALINVOLVEMENTS, familyData[22].getSocialInvolvements());
        values.put(MEMBER_23_KEY_HASRECEIVEDTRAINING, familyData[22].getHasReceivedTraining());
        values.put(MEMBER_23_KEY_TRAININGLIST, familyData[22].getTrainingList());
        values.put(MEMBER_23_KEY_TRAVELWORK, familyData[22].getTravelWork());
        values.put(MEMBER_23_KEY_TRAVELWORKTO, familyData[22].getTravelWorkTo());
        values.put(MEMBER_23_KEY_TRAVELBUSINESS, familyData[22].getTravelBusiness());
        values.put(MEMBER_23_KEY_TRAVELBUSINESSTO, familyData[22].getTravelBusinessTo());
        values.put(MEMBER_23_KEY_TRAVELEDUCATION, familyData[22].getTravelEducation());
        values.put(MEMBER_23_KEY_TRAVELEDUCATIONTO, familyData[22].getTravelEducationTo());
        values.put(MEMBER_23_KEY_TRAVELOTHERS, familyData[22].getTravelOthers());
        values.put(MEMBER_23_KEY_TRAVELOTHERSTO, familyData[22].getTravelOthersTo());

        values.put(MEMBER_24_KEY_NAME_THAR, familyData[23].getName());
        values.put(MEMBER_24_KEY_GENDER, familyData[23].getGender());
        values.put(MEMBER_24_KEY_AGE, familyData[23].getAge());
        values.put(MEMBER_24_KEY_RELATION_TO_OWNER, familyData[23].getRelationToOwner());
        values.put(MEMBER_24_KEY_LEAVE_HOME_6MONTH, familyData[23].getHasLeftHome6Month());
        values.put(MEMBER_24_KEY_LEAVE_HOME_REASON, familyData[23].getLeaveHome_reason());
        values.put(MEMBER_24_KEY_EDUCATION, familyData[23].getEducation());
        values.put(MEMBER_24_KEY_SCHOOL_TYPE, familyData[23].getSchoolType());
        values.put(MEMBER_24_KEY_LEAVE_SCHOOL_REASON, familyData[23].getLeaveSchool_reason());
        values.put(MEMBER_24_KEY_INCOME_SOURCE, familyData[23].getIncomeSource());
        values.put(MEMBER_24_KEY_ABROAD_COUNTRY, familyData[23].getAbroad_country());
        values.put(MEMBER_24_KEY_ABROAD_MONEYTRANSFER, familyData[23].getAbroad_moneyTransfer());
        values.put(MEMBER_24_KEY_SKILLS, familyData[23].getSkills());
        values.put(MEMBER_24_KEY_REGULARDEPOSIT, familyData[23].getRegularDeposit());
        values.put(MEMBER_24_KEY_REGULARDEPOSIT_TO, familyData[23].getRegularDeposit_to());
        values.put(MEMBER_24_KEY_USESVACCINE, familyData[23].getUsesVaccine());
        values.put(MEMBER_24_KEY_SOCIALINVOLVEMENTS, familyData[23].getSocialInvolvements());
        values.put(MEMBER_24_KEY_HASRECEIVEDTRAINING, familyData[23].getHasReceivedTraining());
        values.put(MEMBER_24_KEY_TRAININGLIST, familyData[23].getTrainingList());
        values.put(MEMBER_24_KEY_TRAVELWORK, familyData[23].getTravelWork());
        values.put(MEMBER_24_KEY_TRAVELWORKTO, familyData[23].getTravelWorkTo());
        values.put(MEMBER_24_KEY_TRAVELBUSINESS, familyData[23].getTravelBusiness());
        values.put(MEMBER_24_KEY_TRAVELBUSINESSTO, familyData[23].getTravelBusinessTo());
        values.put(MEMBER_24_KEY_TRAVELEDUCATION, familyData[23].getTravelEducation());
        values.put(MEMBER_24_KEY_TRAVELEDUCATIONTO, familyData[23].getTravelEducationTo());
        values.put(MEMBER_24_KEY_TRAVELOTHERS, familyData[23].getTravelOthers());
        values.put(MEMBER_24_KEY_TRAVELOTHERSTO, familyData[23].getTravelOthersTo());

        values.put(MEMBER_25_KEY_NAME_THAR, familyData[24].getName());
        values.put(MEMBER_25_KEY_GENDER, familyData[24].getGender());
        values.put(MEMBER_25_KEY_AGE, familyData[24].getAge());
        values.put(MEMBER_25_KEY_RELATION_TO_OWNER, familyData[24].getRelationToOwner());
        values.put(MEMBER_25_KEY_LEAVE_HOME_6MONTH, familyData[24].getHasLeftHome6Month());
        values.put(MEMBER_25_KEY_LEAVE_HOME_REASON, familyData[24].getLeaveHome_reason());
        values.put(MEMBER_25_KEY_EDUCATION, familyData[24].getEducation());
        values.put(MEMBER_25_KEY_SCHOOL_TYPE, familyData[24].getSchoolType());
        values.put(MEMBER_25_KEY_LEAVE_SCHOOL_REASON, familyData[24].getLeaveSchool_reason());
        values.put(MEMBER_25_KEY_INCOME_SOURCE, familyData[24].getIncomeSource());
        values.put(MEMBER_25_KEY_ABROAD_COUNTRY, familyData[24].getAbroad_country());
        values.put(MEMBER_25_KEY_ABROAD_MONEYTRANSFER, familyData[24].getAbroad_moneyTransfer());
        values.put(MEMBER_25_KEY_SKILLS, familyData[24].getSkills());
        values.put(MEMBER_25_KEY_REGULARDEPOSIT, familyData[24].getRegularDeposit());
        values.put(MEMBER_25_KEY_REGULARDEPOSIT_TO, familyData[24].getRegularDeposit_to());
        values.put(MEMBER_25_KEY_USESVACCINE, familyData[24].getUsesVaccine());
        values.put(MEMBER_25_KEY_SOCIALINVOLVEMENTS, familyData[24].getSocialInvolvements());
        values.put(MEMBER_25_KEY_HASRECEIVEDTRAINING, familyData[24].getHasReceivedTraining());
        values.put(MEMBER_25_KEY_TRAININGLIST, familyData[24].getTrainingList());
        values.put(MEMBER_25_KEY_TRAVELWORK, familyData[24].getTravelWork());
        values.put(MEMBER_25_KEY_TRAVELWORKTO, familyData[24].getTravelWorkTo());
        values.put(MEMBER_25_KEY_TRAVELBUSINESS, familyData[24].getTravelBusiness());
        values.put(MEMBER_25_KEY_TRAVELBUSINESSTO, familyData[24].getTravelBusinessTo());
        values.put(MEMBER_25_KEY_TRAVELEDUCATION, familyData[24].getTravelEducation());
        values.put(MEMBER_25_KEY_TRAVELEDUCATIONTO, familyData[24].getTravelEducationTo());
        values.put(MEMBER_25_KEY_TRAVELOTHERS, familyData[24].getTravelOthers());
        values.put(MEMBER_25_KEY_TRAVELOTHERSTO, familyData[24].getTravelOthersTo());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int updateDetail(Details details) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_LAT, details.getLatitude());
        values.put(KEY_LNG, details.getLongitude());
        values.put(KEY_ALT, details.getAltitude());
        values.put(KEY_PRADESH, details.getPradesh());
        values.put(KEY_JILLA, details.getJilla());
        values.put(KEY_NAGARPALIKA, details.getNagarpalika());
        values.put(KEY_WARD, details.getWard());
        values.put(KEY_BASTI, details.getBasti());
        values.put(KEY_TOLENAME, details.getTole());
        values.put(KEY_SADAKNAME, details.getSadak());
        values.put(KEY_DHARMA, details.getDharma());

        return db.update(TABLE_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(details.getId())});
    }

    public void deleteDetail(Details details) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, KEY_ID + " =?", new String[]{String.valueOf(details.getId())});

        db.close();

    }

    public Details getDetail(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{
                        KEY_ID,
                        KEY_LAT,
                        KEY_LNG,
                        KEY_ALT,
                        KEY_PRADESH,
                        KEY_JILLA,
                        KEY_NAGARPALIKA,
                        KEY_WARD,
                        KEY_BASTI,
                        KEY_TOLENAME,
                        KEY_SADAKNAME,
                        KEY_DHARMA,
                        KEY_GHARDHANINAME,
                        KEY_GHARDHANIPHONE,
                        KEY_GHARDHANISEX

                }, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        return new Details(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11), //jati
                cursor.getString(12),   //vasa
                cursor.getString(13),  //dharma
                cursor.getString(14), //ghardhaniname
                cursor.getString(15), //ghardhanisex
                cursor.getString(16) //ghardhaniphone
        );
    }

    public List<Details> getAllDetails() {

        List<Details> lstDetail = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Details details = new Details();
                details.setId(cursor.getInt(0));
                details.setLatitude(cursor.getString(1));
                details.setLongitude(cursor.getString(2));
                details.setAltitude(cursor.getString(3));
                details.setPradesh(cursor.getString(4));
                details.setJilla(cursor.getString(5));
                details.setNagarpalika(cursor.getString(6));
                details.setWard(cursor.getString(7));
                details.setBasti(cursor.getString(8));
                details.setTole(cursor.getString(9));
                details.setSadak(cursor.getString(10));
                details.setJati(cursor.getString(11));
                details.setVasa(cursor.getString(12));
                details.setDharma(cursor.getString(13));
                details.setGhardhaniname(cursor.getString(14));
                details.setGhardhanisex(cursor.getString(15));
                details.setGhardhaniphone(cursor.getString(16));


                lstDetail.add(details);
            }
            while (cursor.moveToNext());

        }

        return lstDetail;

    }
}
