package com.lastminute.kmp.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloExperimental
import com.apollographql.apollo.api.ExecutionContext
import com.apollographql.apollo.network.GraphQLResponse
import com.lastminute.kmp.data.mock.MockNetworkTransport
import com.lastminute.kmp.data.mock.TestLoggerExecutor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okio.Buffer
import okio.ByteString.Companion.encodeUtf8
import kotlin.test.Test

@ExperimentalCoroutinesApi
@ApolloExperimental
class ApolloRepoTest : TestBase(){

    private val networkTransport: MockNetworkTransport by lazy { MockNetworkTransport() }
    private val apolloClient: ApolloClient by lazy {
        ApolloClient(
            networkTransport = networkTransport,
            interceptors = listOf(TestLoggerExecutor)
        )
    }

    @Test
    fun `test apollo`() = runTest {
        networkTransport.offer(
            GraphQLResponse(
                body = Buffer().write("{\"data\":{\"search\":[]}}".encodeUtf8()),
                executionContext = ExecutionContext.Empty
            )
        )

        val remoteDs = createRemoteRepoGraphQl(apolloClient, this)

        val res = remoteDs.fetchUser()
        println("======================> $res")
    }
}

val res = """
    {
      "data": {
        "search": [
          {
            "hotelDetail": {
              "id": "1763697",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "1 Double Bed Non Smoking",
                "thumbnail": null,
                "amenities": "PARKING",
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504628/Aerial_View_0_2_d4eaut.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504635/Restaurant_21_23_li0gae.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504637/Restaurant_33_33_nguvr3.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504631/Guestroom_20_22_suggjq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504629/Guestroom_4_6_lgxsyw.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504629/Guestroom_3_5_wwmje2.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504633/Meeting_Facility_25_27_mrlho8.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504632/Lobby_36_36_lgdoup.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504634/Guestroom_34_34_edbnbj.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504630/Interior_Entrance_6_8_sjg3me.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504628/Featured_Image_19_21_i4kuwm.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504634/Exterior_18_20_o2bmlc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504630/Guestroom_13_15_ptjf4j.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504633/Meeting_Facility_8_10_jsdk8a.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504629/Guestroom_2_4_e6sdtf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504634/Miscellaneous_32_32_rfb4t4.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504630/Interior_Entrance_14_1_xqpqcq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504628/Exterior_17_19_ikjcca.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504630/Guestroom_26_28_mzdlcl.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504636/Restaurant_27_29_cqvki2.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504631/Lobby_Sitting_Area_7_9_oeinue.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504635/Miscellaneous_10_12_c9wlre.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504635/Exterior_16_18_kmyqed.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504628/Food_Court_1_3_ksdvpi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504630/Guestroom_15_17_srmpsc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504632/Lobby_35_35_angugm.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504638/Hotel_Bar_22_24_zmmj86.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504634/Exterior_12_14_pbxgbs.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504632/Guestroom_28_30_xudodh.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504630/Guestroom_14_16_g83ko4.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504637/Hotel_Lounge_5_7_kmyafo.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504632/Guestroom_24_26_ng7hsy.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504628/Exterior_29_31_hezu1s.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504637/Restaurant_23_25_cjy4fr.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504635/Reception_9_11_idsroi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1492504632/Lobby_11_13_b6j2ws.jpg"
              ],
              "mealplan": "ACCOMODATION_AND_BREAKFAST",
              "rating": 85,
              "reviews": 4802,
              "coordinates": "51.50654,0.03025",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 226.32
          },
          {
            "hotelDetail": {
              "id": "38211",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "0brm Studio",
                "thumbnail": null,
                "amenities": "PETS_ALLOWED,PARKING,FACILITIES_CHILDREN,FREE_WIFI",
                "images": []
              },
              "images": [
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/cfeabd79_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/59576686_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/b26af4f0_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/5b8a2c53_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/3aa4ec37_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/dcbf5215_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/15b584ca_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/67f6f987_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/c8b3de97_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/aeda91df_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/57d1aa39_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/bf681ab8_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/a7afde3c_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/8e787ea5_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/5f563146_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/4a154dc8_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/b010876d_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/142cef41_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/422e6d62_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/6aadf7c1_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/b55d4dfd_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/a21342a9_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/644673df_z.jpg",
                "//i.travelapi.com/hotels/1000000/450000/447100/447050/5f18f2ec_z.jpg"
              ],
              "mealplan": "ACCOMODATION_ONLY",
              "rating": 85,
              "reviews": 4370,
              "coordinates": "51.50706,-0.1247",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 258.94
          },
          {
            "hotelDetail": {
              "id": "774999",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Double Standard",
                "thumbnail": null,
                "amenities": "FREE_WIFI",
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127654/KEN_BED_single_superior_301_drr3si.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1507563888/Kenilworth_Restaurant_Scoff_and_Banter_dxhtmp.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127619/KEN_LOB_01_p_tgt4fc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024095/Kenilworth_-_Standard_Single_gp8ayt.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127648/KEN_BED_Deluxe_01_nblyl3.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127643/KEN_BED_Deluxe_single_01_h7aduy.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024122/Kenilworth_-_Restaurant_2_pqqzfy.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024096/Kenilworth_-_Single_Room_gbwvxh.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127642/KEN_BED_Deluxe_double_01_lldzbv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127622/KEN_EXT_01_ua2puf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127608/KEN_CON_PS8_01_tzkuno.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024122/Kenilworth_-_Restaurant_1_ymyshy.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127610/KEN_CON_PS15_01_ohnqkf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1507563884/Kenilworth_Restaurant_Scoff_and_Banter_2_w2xswf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145809/KEN_BED_Suite_616_02_fd6tbj.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024096/Kenilworth_-_King_Deluxe_rehyt1.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145700/KEN_BED_Suite_616_01_rudnrg.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024096/Kenilworth_-_Gym_rm7n4b.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024097/Kenilworth_-_Business_Class_with_Sofa_-_Family_gaompv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145564/KEN_BED_std_twin_422_qcm3qs.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024098/Kenilworth_-_Standard_Double_2_boi31x.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145557/KEN_BED_std_single_322_uoujdn.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145695/KEN_BED_Suite_208_01_bwxshh.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127647/KEN_BED_Double_01_r9emoo.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127641/KEN_BED_Business_Class_01_wuwwnp.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1507563886/Kenilworth_Bedroom_Single_tzhcrv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024097/Kenilworth_-_Standard_double_1_nvndux.jpg"
              ],
              "mealplan": "ACCOMODATION_ONLY",
              "rating": 84,
              "reviews": 4149,
              "coordinates": "51.5172,-0.13028",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 260.11
          },
          {
            "hotelDetail": {
              "id": "774999",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Double Standard",
                "thumbnail": null,
                "amenities": "FREE_WIFI",
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127654/KEN_BED_single_superior_301_drr3si.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1507563888/Kenilworth_Restaurant_Scoff_and_Banter_dxhtmp.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127619/KEN_LOB_01_p_tgt4fc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024095/Kenilworth_-_Standard_Single_gp8ayt.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127648/KEN_BED_Deluxe_01_nblyl3.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127643/KEN_BED_Deluxe_single_01_h7aduy.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024122/Kenilworth_-_Restaurant_2_pqqzfy.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024096/Kenilworth_-_Single_Room_gbwvxh.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127642/KEN_BED_Deluxe_double_01_lldzbv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127622/KEN_EXT_01_ua2puf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127608/KEN_CON_PS8_01_tzkuno.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024122/Kenilworth_-_Restaurant_1_ymyshy.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127610/KEN_CON_PS15_01_ohnqkf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1507563884/Kenilworth_Restaurant_Scoff_and_Banter_2_w2xswf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145809/KEN_BED_Suite_616_02_fd6tbj.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024096/Kenilworth_-_King_Deluxe_rehyt1.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145700/KEN_BED_Suite_616_01_rudnrg.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024096/Kenilworth_-_Gym_rm7n4b.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024097/Kenilworth_-_Business_Class_with_Sofa_-_Family_gaompv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145564/KEN_BED_std_twin_422_qcm3qs.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024098/Kenilworth_-_Standard_Double_2_boi31x.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145557/KEN_BED_std_single_322_uoujdn.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430145695/KEN_BED_Suite_208_01_bwxshh.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127647/KEN_BED_Double_01_r9emoo.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430127641/KEN_BED_Business_Class_01_wuwwnp.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1507563886/Kenilworth_Bedroom_Single_tzhcrv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1547024097/Kenilworth_-_Standard_double_1_nvndux.jpg"
              ],
              "mealplan": "ACCOMODATION_AND_BREAKFAST",
              "rating": 84,
              "reviews": 4149,
              "coordinates": "51.5172,-0.13028",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 319.57
          },
          {
            "hotelDetail": {
              "id": "2626198",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Small Double Room Queenbed",
                "thumbnail": null,
                "amenities": null,
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885367/Small_Double_mjku6x.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885274/DBL_dfpcpe.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885689/outside_vbm3kc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885396/Single_dxnrar.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885917/Cote_zj6vmm.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885169/Lobby_smaller_size_umg53u.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885973/Bathrooms_mti3ok.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885792/Cafe3_pwxkt4.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885836/Breakfast_cnn5t9.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885135/Exterior_chwnpb.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885431/Superior_fiejgp.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885452/Twin_hivrx0.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885507/Club_perqmu.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885770/Cafe2_r48v8t.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885202/Lobby_2_af709a.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1462885723/sloan0714-34_xnhkcv.jpg"
              ],
              "mealplan": "ACCOMODATION_ONLY",
              "rating": 84,
              "reviews": 1642,
              "coordinates": "51.4928,-0.15723",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 279.52
          },
          {
            "hotelDetail": {
              "id": "934782",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Double Superior Room 1 Double Bed",
                "thumbnail": null,
                "amenities": "POOL",
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126577/grange-st-pauls-swimming-pool-iv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/leonardoroyalhotellondonstpauls85_mw9jj4.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386946/superior_room_ielwfd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013721/lls-spa26_hdhghi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/ajalaspamandarinsuite_qyksaf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/suite_j85s2t.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648258/Screen_Shot_2020-01-10_at_09.22.27_xcqngc.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648258/Screen_Shot_2020-01-10_at_09.23.25_jxjup7.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/lls-skybar9_smsjph.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126455/grange-st-pauls-breakfast-room-day.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/studioapartment_ymxuxd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/quarter_jacks_bar_je1y4f.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/leonardoroyalhotellondonstpauls83_k0vx78.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126439/grange-st-pauls-ajalsprelaxation-lounge-i.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/lls-restaurant6_qp8ftc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648256/Screen_Shot_2020-01-10_at_09.22.50_armmdz.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/novello4_pcb2gq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/club_f6e1te.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648258/Screen_Shot_2020-01-10_at_09.23.12_iqytou.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/lls-skybar12_vqfspk.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126522/grange-st-pauls-atrium-at-ni.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013721/lls-spa25_fkjkhd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126542/grange-st-pauls-silk-bar-ii.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/leonardoroyalhotellondonstpauls81_c4ldyd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/skybariicopy_h6dh2x.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126528/grange-st-pauls-bedroom-1-pic4-v2.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/rm701-royalsuitexiiicopy_d8nc4i.jpg"
              ],
              "mealplan": "ACCOMODATION_ONLY",
              "rating": 83,
              "reviews": 5870,
              "coordinates": "51.51268,-0.09937",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 236.79
          },
          {
            "hotelDetail": {
              "id": "934782",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Double Superior Room 1 Double Bed",
                "thumbnail": null,
                "amenities": "POOL",
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126577/grange-st-pauls-swimming-pool-iv.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/leonardoroyalhotellondonstpauls85_mw9jj4.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386946/superior_room_ielwfd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013721/lls-spa26_hdhghi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/ajalaspamandarinsuite_qyksaf.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/suite_j85s2t.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648258/Screen_Shot_2020-01-10_at_09.22.27_xcqngc.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648258/Screen_Shot_2020-01-10_at_09.23.25_jxjup7.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/lls-skybar9_smsjph.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126455/grange-st-pauls-breakfast-room-day.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/studioapartment_ymxuxd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/quarter_jacks_bar_je1y4f.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/leonardoroyalhotellondonstpauls83_k0vx78.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126439/grange-st-pauls-ajalsprelaxation-lounge-i.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/lls-restaurant6_qp8ftc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648256/Screen_Shot_2020-01-10_at_09.22.50_armmdz.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/novello4_pcb2gq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386944/club_f6e1te.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1578648258/Screen_Shot_2020-01-10_at_09.23.12_iqytou.png",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/lls-skybar12_vqfspk.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126522/grange-st-pauls-atrium-at-ni.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013721/lls-spa25_fkjkhd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126542/grange-st-pauls-silk-bar-ii.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1570013720/leonardoroyalhotellondonstpauls81_c4ldyd.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/skybariicopy_h6dh2x.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1425126528/grange-st-pauls-bedroom-1-pic4-v2.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1564386945/rm701-royalsuitexiiicopy_d8nc4i.jpg"
              ],
              "mealplan": "ACCOMODATION_AND_BREAKFAST",
              "rating": 83,
              "reviews": 5870,
              "coordinates": "51.51268,-0.09937",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 306.93
          },
          {
            "hotelDetail": {
              "id": "189079",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Standard Studio Fullbed",
                "thumbnail": null,
                "amenities": "FACILITIES_CHILDREN,FREE_WIFI",
                "images": []
              },
              "images": [
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/dcee66fe_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/b12a85ba_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/cd7e541a_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/a8db5a35_b.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/2a57fd46_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/e7b8ac26_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/402b722d_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/2f6bc15f_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/5787f95f_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/cd414402_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/02ba1aae_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/529a6a5f_b.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/334e1378_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/8f102930_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/68e8eb5e_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/c30f1059_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/6174251a_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/7a60a853_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/fe6673dd_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/f664cf29_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/25dcfacc_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/018d38d7_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/fa8b62a6_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/7a6576d4_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/24f50e33_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/60bcbac3_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/5a28dba2_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/163c03a7_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/0d2d72cc_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/9bc765b5_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/6ffa7d76_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/6ae7ce56_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/bedb9886_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/de80dc7c_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/09903a5a_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/f8a6eaac_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/791b7e6d_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/da45c35c_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/8954ca6a_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/19b8f0b9_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/ca4fdce4_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/396cc2a9_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/1283917f_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/74081304_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/6015c8bc_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/42c4e706_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/e7820eec_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/0c7aaa84_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/ce342e4f_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/60575f57_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/a56f421c_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/7b15e8be_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/f005cf52_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/0764a521_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/aeff33c3_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/80b84f54_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/ee64df4e_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/d82b2ff9_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/7eb79769_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/015f83cb_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/234b6d7c_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/e9cc2738_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/895ae97d_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/d5b8a08d_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/ee6779bb_z.jpg",
                "//i.travelapi.com/hotels/3000000/2760000/2752100/2752030/c94f4a30_z.jpg"
              ],
              "mealplan": "ACCOMODATION_ONLY",
              "rating": 83,
              "reviews": 1898,
              "coordinates": "51.49255,-0.19062",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 210.19
          },
          {
            "hotelDetail": {
              "id": "269722",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Deluxe Room 1 Double Bed Accessible Fullbed",
                "thumbnail": null,
                "amenities": "PETS_ALLOWED,FREE_WIFI",
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138737/Exterior_By_Night_ev2wsq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138730/Bathroom_p5wx5f.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138742/King_Executive_Suite_2_c1qhbb.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138729/Bathroom_2_eloofn.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138735/Executive_Lounge_tnrep5.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138741/King_Executive_Room_2_xawinx.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138726/Angel_Afternoon_Tea_hcbnxs.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138738/Hilton_Double_Guest_Room_mjwcvt.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138739/Hilton_London_Islington_Lobby_duirm7.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138746/Twin_Executive_Room_ofdnc5.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138747/Twin_Guest_Room_u1i3oi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138731/Deluxe_Room_lrfjmi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138743/King_Executive_Suite_qwgynq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138737/Family_Room_gga8pt.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138740/Junior_Suite_pbhces.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138748/Accessible_Bathroom_fqdnqc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138733/Executive_Lounge_2_kwkmyr.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138750/Terrace_jprulk.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138733/Axis_Bar_Restaurant_mb6dpd.jpg"
              ],
              "mealplan": "ACCOMODATION_ONLY",
              "rating": 83,
              "reviews": 2678,
              "coordinates": "51.53535,-0.10416",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 260.98
          },
          {
            "hotelDetail": {
              "id": "269722",
              "checkIn": "2020-10-25",
              "checkOut": "2020-10-27",
              "room": {
                "name": "Deluxe Room 1 Double Bed Accessible Fullbed",
                "thumbnail": null,
                "amenities": "PETS_ALLOWED,FREE_WIFI",
                "images": []
              },
              "images": [
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138737/Exterior_By_Night_ev2wsq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138730/Bathroom_p5wx5f.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138742/King_Executive_Suite_2_c1qhbb.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138729/Bathroom_2_eloofn.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138735/Executive_Lounge_tnrep5.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138741/King_Executive_Room_2_xawinx.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138726/Angel_Afternoon_Tea_hcbnxs.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138738/Hilton_Double_Guest_Room_mjwcvt.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138739/Hilton_London_Islington_Lobby_duirm7.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138746/Twin_Executive_Room_ofdnc5.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138747/Twin_Guest_Room_u1i3oi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138731/Deluxe_Room_lrfjmi.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138743/King_Executive_Suite_qwgynq.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138737/Family_Room_gga8pt.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138740/Junior_Suite_pbhces.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138748/Accessible_Bathroom_fqdnqc.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138733/Executive_Lounge_2_kwkmyr.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138750/Terrace_jprulk.jpg",
                "//res.cloudinary.com/lastminute/image/upload/q_auto/w_0.5/v1430138733/Axis_Bar_Restaurant_mb6dpd.jpg"
              ],
              "mealplan": "ACCOMODATION_AND_BREAKFAST",
              "rating": 83,
              "reviews": 2678,
              "coordinates": "51.53535,-0.10416",
              "address": null,
              "cancellationFree": false
            },
            "flightDetail": {
              "id": "1000003113633SCHv01-2127425254",
              "airline": "BA",
              "originAirport": "MAD",
              "destinationAirport": "LHR",
              "outboundFlightDuration": 145,
              "outboundDeparture": "2020-10-25T07:00:00+01:00[Europe/Madrid]",
              "outboundArrival": "2020-10-25T08:25:00+00:00[Europe/London]",
              "returnFlightDuration": 140,
              "returnDeparture": "2020-10-27T20:20:00+00:00[Europe/London]",
              "returnArrival": "2020-10-27T23:40:00+01:00[Europe/Madrid]"
            },
            "totalPrice": 313.25
          }
        ]
      }
    }
""".trimIndent()

