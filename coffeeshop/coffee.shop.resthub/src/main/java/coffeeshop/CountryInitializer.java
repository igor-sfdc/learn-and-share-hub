package coffeeshop;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.common.util.PostInitialize;

import coffeeshop.model.Country;
import coffeeshop.repository.CountryRepository;

@Named("CountryInitializer")
public class CountryInitializer {

    @Inject
    @Named("countryRepository")
    private CountryRepository countryRepository;

    // CountryInitializer needs to be executed first
    @PostInitialize(order=1)
    public void init() {
    	Country country1 = new Country("Noveo Zimlya");
    	country1.setLatitude(69.7012621);
    	country1.setLongitude(52.3030044);
    	country1.setZoom(8);
    	countryRepository.save(country1);

    	Country country2 = new Country("Colombia");
    	country2.setLatitude(4.1156735);
    	country2.setLongitude(-72.9301367);
    	country2.setZoom(6);
    	countryRepository.save(country2);

    	Country country3 = new Country("Ecuador");
    	country3.setLatitude(-1.7929665);
    	country3 .setLongitude(-78.1368875);
    	country3 .setZoom(7);
    	countryRepository.save(country3);

    	Country country4 = new Country("Peru");
    	country4.setLatitude(-9.1951786);
    	country4.setLongitude(-74.9904165);
    	country4.setZoom(6);
    	countryRepository.save(country4);

    	Country country5 = new Country("Bolivia");
    	country5.setLatitude(-16.2837065);
    	country5.setLongitude(-63.5493965);
    	country5.setZoom(6);
    	countryRepository.save(country5);

    	Country country6 = new Country("Paraguay");
    	country6.setLatitude(-23.4380203);
    	country6.setLongitude(-58.4483065);
    	country6 .setZoom(7);
    	countryRepository.save(country6);

    	Country country7 = new Country("Chile");
    	country7.setLatitude(-36.739055);
    	country7.setLongitude(-71.0574942);
    	country7 .setZoom(4);
    	countryRepository.save(country7);

    	Country country8 = new Country("Argentina");
    	country8.setLatitude(-37.2391747);
    	country8.setLongitude(-63.6648384);
    	country8 .setZoom(5);
    	countryRepository.save(country8);

    	Country country9 = new Country("Brazil");
    	country9.setLatitude(-10.3334774);
    	country9.setLongitude(-52.0928553);
    	country9 .setZoom(6);
    	countryRepository.save(country9);

    	Country country10 = new Country("Guatemala");
    	country10.setLatitude(15.7778663);
    	country10.setLongitude(-90.2287257);
    	country10 .setZoom(8);
    	countryRepository.save(country10);

    	Country country11 = new Country("Mexico");
    	country11.setLatitude(23.4856642);
    	country11.setLongitude(-101.9991705);
    	country11.setZoom(6);
    	countryRepository.save(country11);

    	Country country12 = new Country("Hawaii");
    	country12.setLatitude(20.46);
    	country12.setLongitude(-157.505);
    	country12.setZoom(8);
    	countryRepository.save(country12);

    	Country country13 = new Country("Ethiopia");
    	country13.setLatitude(8.3782587);
    	country13.setLongitude(40.7131003);
    	country13.setZoom(7);
    	countryRepository.save(country13);

    	Country country14 = new Country("Kenya");
    	country14.setLatitude(8.3782587);
    	country14.setLongitude(40.7131003);
    	country14.setZoom(7);
    	countryRepository.save(country14);

    	Country country15 = new Country("Vietnam");
    	country15.setLatitude(13.0953646);
    	country15.setLongitude(107.9462799);
    	country15.setZoom(8);
    	countryRepository.save(country15);

    	Country country16 = new Country("Indonesia");
    	country16.setLatitude(-1.7145503);
    	country16.setLongitude(119.3551955);
    	country16.setZoom(5);
    	countryRepository.save(country16);

    	Country country17 = new Country("India");
    	country17.setLatitude(21.9669027);
    	country17.setLongitude(79.1866461);
    	country17.setZoom(6);
    	countryRepository.save(country17);

    	Country country18 = new Country("Honduras");
    	country18.setLatitude(15.2650424);
    	country18.setLongitude(-86.892281);
    	country18.setZoom(8);
    	countryRepository.save(country18);

    	Country country19 = new Country("Uganda");
    	country19.setLatitude(1.5189977);
    	country19.setLongitude(32.5367009);
    	country19.setZoom(8);
    	countryRepository.save(country19);

    	Country country20 = new Country("Ivory Coast");
    	country20.setLatitude(7.2350022);
    	country20.setLongitude(-5.2811265);
    	country20.setZoom(8);
    	countryRepository.save(country20);

    	Country country21 = new Country("Costa Rica");
    	country21.setLatitude(9.6897572);
    	country21.setLongitude(-83.8641697);
    	country21.setZoom(8);
    	countryRepository.save(country21);

    	Country country22 = new Country("El Salvador");
    	country22.setLatitude(13.802994);
    	country22.setLongitude(-88.905281);
    	country22.setZoom(9);
    	countryRepository.save(country22);

    	Country country23 = new Country("Nicaragua");
    	country23.setLatitude(12.8263201);
    	country23.setLongitude(-85.0536794);
    	country23.setZoom(8);
    	countryRepository.save(country23);

    	Country country24 = new Country("Papua New Guinea");
    	country24.setLatitude(-6.2973513);
    	country24.setLongitude(146.4864297);
    	country24.setZoom(7);
    	countryRepository.save(country24);

    	Country country25 = new Country("Thailand");
    	country25.setLatitude(16.0691649);
    	country25.setLongitude(102.0119546);
    	country25.setZoom(7);
    	countryRepository.save(country25);

    	Country country26 = new Country("Tanzania");
    	country26.setLatitude(-6.7657355);
    	country26.setLongitude(35.1506614);
    	country26.setZoom(7);
    	countryRepository.save(country26);

    	Country country27 = new Country("Dominican Republic");
    	country27.setLatitude(19.0465589);
    	country27.setLongitude(-70.4552228);
    	country27.setZoom(9);
    	countryRepository.save(country27);

    	Country country28 = new Country("Cameroon");
    	country28.setLatitude(5.5739908);
    	country28.setLongitude(12.7318537);
    	country28.setZoom(8);
    	countryRepository.save(country28);

    	Country country29 = new Country("Philippines");
    	country29.setLatitude(11.5883663);
    	country29.setLongitude(122.373256);
    	country29.setZoom(7);
    	countryRepository.save(country29);

    	Country country30 = new Country("Democratic Republic of the Congo");
    	country30.setLatitude(-3.1124685);
    	country30.setLongitude(22.1620476);
    	country30.setZoom(7);
    	countryRepository.save(country30);
    	 
    	Country country31 = new Country("Rwanda");
    	country31.setLatitude(-1.8778244);
    	country31.setLongitude(29.9883811);
    	country31.setZoom(10);
    	countryRepository.save(country31);

    	Country country32 = new Country("Guinea");
    	country32.setLatitude(10.2518443);
    	country32.setLongitude(-11.0092136);
    	country32.setZoom(8);
    	countryRepository.save(country32);

    	Country country33 = new Country("Cuba");
    	country33.setLatitude(21.9492879);
    	country33.setLongitude(-78.5388079);
    	country33.setZoom(8);
    	countryRepository.save(country33);

    	Country country34 = new Country("Togo");
    	country34.setLatitude(8.6177801);
    	country34.setLongitude(0.8997954);
    	country34.setZoom(9);
    	countryRepository.save(country34);

    	Country country35 = new Country("Zambia");
    	country35.setLatitude(-13.4290435);
    	country35.setLongitude(27.8438117);
    	country35.setZoom(7);
    	countryRepository.save(country35);

    	Country country36 = new Country("Angola");
    	country36.setLatitude(-12.0958201);
    	country36.setLongitude(18.3109632);
    	country36.setZoom(7);
    	countryRepository.save(country36);

    	Country country37 = new Country("Central African Republic");
    	country37.setLatitude(6.7830763);
    	country37.setLongitude(20.7334546);
    	country37.setZoom(7);
    	countryRepository.save(country37);

    	Country country38 = new Country("Panama");
    	country38.setLatitude(8.8436879);
    	country38.setLongitude(-80.0531795);
    	country38.setZoom(8);
    	countryRepository.save(country38);

    	Country country39 = new Country("Zimbabwe");
    	country39.setLatitude(-18.8402533);
    	country39.setLongitude(29.7652896);
    	country39.setZoom(8);
    	countryRepository.save(country39);

    	Country country40 = new Country("United States");
    	country40.setLatitude(40.8002119);
    	country40.setLongitude(-98.7191992);
    	country40.setZoom(5);
    	countryRepository.save(country40);

    	Country country41 = new Country("Nigeria");
    	country41.setLatitude(9.5547719);
    	country41.setLongitude(8.3423737);
    	country41.setZoom(7);
    	countryRepository.save(country41);

    	Country country42 = new Country("Ghana");
    	country42.setLatitude(8.5942144);
    	country42.setLongitude(-0.8082386);
    	country42.setZoom(8);
    	countryRepository.save(country42);

    	Country country43 = new Country("Jamaica");
    	country43.setLatitude(18.1755471);
    	country43.setLongitude(-77.2876755);
    	country43.setZoom(10);
    	countryRepository.save(country43);

    	Country country44 = new Country("Sri Lanka");
    	country44.setLatitude(7.8612151);
    	country44.setLongitude(80.8060862);
    	country44.setZoom(9);
    	countryRepository.save(country44);

    	Country country45 = new Country("Malawi");
    	country45.setLatitude(-13.577157);
    	country45.setLongitude(33.9554585);
    	country45.setZoom(8);
    	countryRepository.save(country45);

    	Country country46 = new Country("Sierra Leone");
    	country46.setLatitude(8.4277641);
    	country46.setLongitude(-11.6618594);
    	country46.setZoom(9);
    	countryRepository.save(country46);

    	Country country47 = new Country("Trinidad and Tobago");
    	country47.setLatitude(10.4282923);
    	country47.setLongitude(-61.3392017);
    	country47.setZoom(11);
    	countryRepository.save(country47);

    	Country country48 = new Country("Republic of the Congo");
    	country48.setLatitude(-0.5726933);
    	country48.setLongitude(14.9048192);
    	country48.setZoom(8);
    	countryRepository.save(country48);

    	Country country49 = new Country("Equatorial Guinea");
    	country49.setLatitude(1.56065);
    	country49.setLongitude(10.5283148);
    	country49.setZoom(10);
    	countryRepository.save(country49);

    	Country country50 = new Country("Gabon");
    	country50.setLatitude(-0.9629363);
    	country50.setLongitude(12.2003196);
    	country50.setZoom(8);
    	countryRepository.save(country50);

    	Country country51 = new Country("Benin");
    	country51.setLatitude(9.6526207);
    	country51.setLongitude(2.4336013);
    	country51.setZoom(8);
    	countryRepository.save(country51);
    }
}
