package org.kasad0r;

import org.kasad0r.domain.Region;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class RegionData {
    public static List<Region> worldRegionsList;

    public static void init() {
        Region europe = new Region();
        europe.setName("Europe");
        europe.setPopulation(741_400_000L);
        europe.getAirportsCoords().add(new Point(802, 159));
        europe.getAirportsCoords().add(new Point(726, 322));//British
        europe.getAirportsCoords().add(new Point(815, 347));//British
        europe.getAirportsCoords().add(new Point(714, 394));//British
        europe.getPortsCoords().add(new Point(767, 227));
        europe.getPortsCoords().add(new Point(841, 137));
        europe.getPortsCoords().add(new Point(797, 387));
        europe.getPortsCoords().add(new Point(745, 303));
        europe.regionFillCords
                .add(new Point(768, 336));
        europe.regionFillCords.add(new Point(801, 237));
        europe.regionFillCords.add(new Point(813, 132));
        europe.regionFillCords.add(new Point(721, 317));
        europe.regionFillCords.add(new Point(695, 312));
        Region asia = new Region();
        asia.setName("Asia");
        asia.setPopulation(4_463_000_000L);
        asia.getAirportsCoords().add(new Point(923, 322));
        asia.getAirportsCoords().add(new Point(911, 455));
        asia.getAirportsCoords().add(new Point(1252, 383));
        asia.getAirportsCoords().add(new Point(1057, 478));
        asia.getAirportsCoords().add(new Point(1104, 230));
        asia.getPortsCoords().add(new Point(1262, 409));
        asia.getPortsCoords().add(new Point(962, 478));
        asia.getPortsCoords().add(new Point(1160, 563));
        asia.getPortsCoords().add(new Point(869, 234));
        asia.getPortsCoords().add(new Point(1322, 573));

        asia.regionFillCords.add(new Point(1067, 324));
        asia.regionFillCords.add(new Point(965, 172));
        asia.regionFillCords.add(new Point(1125, 128));
        asia.regionFillCords.add(new Point(1149, 139));
        asia.regionFillCords.add(new Point(1315, 168));
        asia.regionFillCords.add(new Point(1323, 330));
        asia.regionFillCords.add(new Point(1305, 399));
        asia.regionFillCords.add(new Point(1323, 365));
        asia.regionFillCords.add(new Point(1313, 576));
        asia.regionFillCords.add(new Point(1370, 575));
        asia.regionFillCords.add(new Point(1228, 490));
        asia.regionFillCords.add(new Point(1247, 521));
        asia.regionFillCords.add(new Point(1202, 546));
        asia.regionFillCords.add(new Point(1159, 564));
        asia.regionFillCords.add(new Point(1152, 536));
        asia.regionFillCords.add(new Point(1235, 569));

        asia.setInfected(1);

        Region africa = new Region();
        africa.setPopulation(1_216_000_000);
        africa.setName("Africa");
        africa.getAirportsCoords().add(new Point(846, 214));
        africa.getAirportsCoords().add(new Point(706, 492));
        africa.getAirportsCoords().add(new Point(928, 522));
        africa.getAirportsCoords().add(new Point(826, 634));


        africa.getPortsCoords().add(new Point(913, 562));
        africa.getPortsCoords().add(new Point(822, 702));
        africa.getPortsCoords().add(new Point(764, 564));
        africa.getPortsCoords().add(new Point(659, 468));

        africa.regionFillCords.add(new Point(795, 507));
        africa.regionFillCords.add(new Point(918, 628));


        Region northAndCentralAmerica = new Region();
        northAndCentralAmerica.setName("North and Central America");
        northAndCentralAmerica.setPopulation(498_000_000L);
        northAndCentralAmerica.getAirportsCoords().add(new Point(577, 168));
        northAndCentralAmerica.getAirportsCoords().add(new Point(112, 247));
        northAndCentralAmerica.getAirportsCoords().add(new Point(300, 334));
        northAndCentralAmerica.getAirportsCoords().add(new Point(369, 423));
        northAndCentralAmerica.getAirportsCoords().add(new Point(350, 494));
        northAndCentralAmerica.getPortsCoords().add(new Point(540, 294));
        northAndCentralAmerica.getPortsCoords().add(new Point(458, 382));
        northAndCentralAmerica.getPortsCoords().add(new Point(250, 458));
        northAndCentralAmerica.getPortsCoords().add(new Point(166, 326));
        northAndCentralAmerica.regionFillCords.add(new Point(331, 389));
        northAndCentralAmerica.regionFillCords.add(new Point(386, 465));
        northAndCentralAmerica.regionFillCords.add(new Point(439, 481));
        northAndCentralAmerica.regionFillCords.add(new Point(265, 461));
        northAndCentralAmerica.regionFillCords.add(new Point(496, 344));
        northAndCentralAmerica.regionFillCords.add(new Point(655, 242));
        northAndCentralAmerica.regionFillCords.add(new Point(506, 117));
        northAndCentralAmerica.regionFillCords.add(new Point(401, 121));
        northAndCentralAmerica.regionFillCords.add(new Point(430, 217));
        northAndCentralAmerica.regionFillCords.add(new Point(327, 190));
        northAndCentralAmerica.regionFillCords.add(new Point(349, 165));
        northAndCentralAmerica.regionFillCords.add(new Point(310, 142));
        northAndCentralAmerica.regionFillCords.add(new Point(219, 185));
        northAndCentralAmerica.regionFillCords.add(new Point(383, 249));
        northAndCentralAmerica.regionFillCords.add(new Point(379, 223));

        Region southAmerica = new Region();
        southAmerica.setName("South America");
        southAmerica.getAirportsCoords().add(new Point(455, 533));
        southAmerica.getAirportsCoords().add(new Point(569, 593));
        southAmerica.getAirportsCoords().add(new Point(449, 718));
        southAmerica.getAirportsCoords().add(new Point(421, 606));
        southAmerica.getPortsCoords().add(new Point(477, 769));
        southAmerica.getPortsCoords().add(new Point(604, 585));
        southAmerica.getPortsCoords().add(new Point(467, 506));
        southAmerica.getPortsCoords().add(new Point(389, 558));
        southAmerica.setPopulation(422_500_00L);

        southAmerica.regionFillCords.add(new Point(455, 616));

        Region australia = new Region();
        australia.getAirportsCoords().add(new Point(1214, 650));
        australia.getAirportsCoords().add(new Point(1284, 612));
        australia.getAirportsCoords().add(new Point(1357, 669));
        australia.getAirportsCoords().add(new Point(1334, 700));
        australia.getPortsCoords().add(new Point(1218, 614));
        australia.getPortsCoords().add(new Point(1238, 701));
        australia.getPortsCoords().add(new Point(1238, 701));
        australia.getPortsCoords().add(new Point(1381, 672));
        australia.getPortsCoords().add(new Point(1437, 762));
        australia.setPopulation(25_000_000);
        australia.setName("Australia");
        australia.regionFillCords.add(new Point(1294, 653));
        australia.regionFillCords.add(new Point(1336, 738));
        australia.regionFillCords.add(new Point(1425, 756));
        australia.regionFillCords.add(new Point(1457, 720));
        worldRegionsList = Arrays.asList(africa, asia, southAmerica,
                australia, northAndCentralAmerica, europe);
    }
}
