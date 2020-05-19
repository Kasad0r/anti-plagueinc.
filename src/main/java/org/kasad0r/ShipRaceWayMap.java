package org.kasad0r;

import org.kasad0r.domain.ShipRace;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShipRaceWayMap {
    public static List<ShipRace> shipRaces = new ArrayList<>();

    public static void init() {
        shipRaces = new ArrayList<>();
        ShipRace usaToEurope = new ShipRace();
        usaToEurope.way.add(new Point(175, 347));
        usaToEurope.way.add(new Point(191, 386));
        usaToEurope.way.add(new Point(223, 478));
        usaToEurope.way.add(new Point(247, 602));
        usaToEurope.way.add(new Point(342, 706));
        usaToEurope.way.add(new Point(383, 811));
        usaToEurope.way.add(new Point(510, 835));
        usaToEurope.way.add(new Point(576, 742));
        usaToEurope.way.add(new Point(673, 644));
        usaToEurope.way.add(new Point(700, 585));
        usaToEurope.way.add(new Point(663, 529));
        usaToEurope.way.add(new Point(571, 469));
        usaToEurope.way.add(new Point(546, 390));
        usaToEurope.way.add(new Point(603, 313));
        usaToEurope.way.add(new Point(697, 277));
        usaToEurope.way.add(new Point(780, 246));

        ShipRace southAmericaToAfrica = new ShipRace();
        southAmericaToAfrica.way.add(new Point(400, 581));
        southAmericaToAfrica.way.add(new Point(381, 611));
        southAmericaToAfrica.way.add(new Point(370, 661));
        southAmericaToAfrica.way.add(new Point(340, 704));
        southAmericaToAfrica.way.add(new Point(320, 718));
        southAmericaToAfrica.way.add(new Point(293, 760));
        southAmericaToAfrica.way.add(new Point(322, 804));
        southAmericaToAfrica.way.add(new Point(406, 834));
        southAmericaToAfrica.way.add(new Point(477, 832));
        southAmericaToAfrica.way.add(new Point(540, 827));
        southAmericaToAfrica.way.add(new Point(587, 775));
        southAmericaToAfrica.way.add(new Point(613, 711));
        southAmericaToAfrica.way.add(new Point(656, 629));
        southAmericaToAfrica.way.add(new Point(779, 584));
        ShipRace southAmericaToAsia = new ShipRace();
        southAmericaToAsia.way.add(new Point(480, 784));
        southAmericaToAsia.way.add(new Point(514, 773));
        southAmericaToAsia.way.add(new Point(607, 778));
        southAmericaToAsia.way.add(new Point(688, 802));
        southAmericaToAsia.way.add(new Point(803, 806));
        southAmericaToAsia.way.add(new Point(939, 820));
        southAmericaToAsia.way.add(new Point(988, 775));
        southAmericaToAsia.way.add(new Point(1076, 673));
        southAmericaToAsia.way.add(new Point(1100, 624));
        southAmericaToAsia.way.add(new Point(1068, 545));
        southAmericaToAsia.way.add(new Point(994, 495));
        southAmericaToAsia.way.add(new Point(963, 491));
        ShipRace usaToAfrica = new ShipRace();
        usaToAfrica.way.add(new Point(486, 516));
        usaToAfrica.way.add(new Point(529, 490));
        usaToAfrica.way.add(new Point(583, 501));
        usaToAfrica.way.add(new Point(624, 483));
        usaToAfrica.way.add(new Point(645, 403));
        usaToAfrica.way.add(new Point(626, 366));
        usaToAfrica.way.add(new Point(630, 328));
        usaToAfrica.way.add(new Point(623, 296));
        usaToAfrica.way.add(new Point(588, 291));
        usaToAfrica.way.add(new Point(547, 310));
        ShipRace usaToAsia = new ShipRace();
        usaToAsia.way.add(new Point(485, 513));
        usaToAsia.way.add(new Point(600, 511));
        usaToAsia.way.add(new Point(704, 576));
        usaToAsia.way.add(new Point(742, 682));
        usaToAsia.way.add(new Point(771, 756));
        usaToAsia.way.add(new Point(858, 806));
        usaToAsia.way.add(new Point(978, 816));
        usaToAsia.way.add(new Point(1067, 769));
        usaToAsia.way.add(new Point(1079, 702));
        usaToAsia.way.add(new Point(1097, 636));
        usaToAsia.way.add(new Point(1132, 604));
        usaToAsia.way.add(new Point(1192, 577));
        ShipRace afircaToChina = new ShipRace();
        afircaToChina.way.add(new Point(939, 581));
        afircaToChina.way.add(new Point(1011, 585));
        afircaToChina.way.add(new Point(1078, 636));
        afircaToChina.way.add(new Point(1116, 691));
        afircaToChina.way.add(new Point(1152, 739));
        afircaToChina.way.add(new Point(1222, 765));
        afircaToChina.way.add(new Point(1303, 782));
        afircaToChina.way.add(new Point(1367, 784));
        afircaToChina.way.add(new Point(1394, 784));
        afircaToChina.way.add(new Point(1453, 766));
        afircaToChina.way.add(new Point(1455, 654));
        afircaToChina.way.add(new Point(1483, 585));
        afircaToChina.way.add(new Point(1493, 544));
        afircaToChina.way.add(new Point(1464, 492));
        afircaToChina.way.add(new Point(1357, 462));
        afircaToChina.way.add(new Point(1281, 430));
        afircaToChina.way.add(new Point(1267, 427));
        ShipRace asiaToAustralia = new ShipRace();
        asiaToAustralia.way.add(new Point(1289, 532));
        asiaToAustralia.way.add(new Point(1298, 522));
        asiaToAustralia.way.add(new Point(1311, 510));
        asiaToAustralia.way.add(new Point(1321, 486));
        asiaToAustralia.way.add(new Point(1318, 456));
        asiaToAustralia.way.add(new Point(1322, 426));
        asiaToAustralia.way.add(new Point(1334, 420));
        asiaToAustralia.way.add(new Point(1343, 385));
        asiaToAustralia.way.add(new Point(1356, 369));
        asiaToAustralia.way.add(new Point(1375, 342));
        asiaToAustralia.way.add(new Point(1421, 306));
        asiaToAustralia.way.add(new Point(1439, 298));
        asiaToAustralia.way.add(new Point(1468, 313));
        asiaToAustralia.way.add(new Point(1483, 353));
        asiaToAustralia.way.add(new Point(1460, 434));
        asiaToAustralia.way.add(new Point(1435, 621));
        asiaToAustralia.way.add(new Point(1418, 644));
        asiaToAustralia.way.add(new Point(1395, 674));
        asiaToAustralia.way.add(new Point(1399, 714));
        ShipRace greenlandToAustralia = new ShipRace();
        greenlandToAustralia.way.add(new Point(555, 282));
        greenlandToAustralia.way.add(new Point(570, 330));
        greenlandToAustralia.way.add(new Point(576, 397));
        greenlandToAustralia.way.add(new Point(581, 447));
        greenlandToAustralia.way.add(new Point(595, 508));
        greenlandToAustralia.way.add(new Point(645, 545));
        greenlandToAustralia.way.add(new Point(689, 618));
        greenlandToAustralia.way.add(new Point(680, 694));
        greenlandToAustralia.way.add(new Point(750, 773));
        greenlandToAustralia.way.add(new Point(885, 798));
        greenlandToAustralia.way.add(new Point(979, 758));
        greenlandToAustralia.way.add(new Point(1097, 749));
        greenlandToAustralia.way.add(new Point(1140, 804));
        greenlandToAustralia.way.add(new Point(1307, 830));
        greenlandToAustralia.way.add(new Point(1385, 802));
        greenlandToAustralia.way.add(new Point(1427, 771));
        greenlandToAustralia.way.add(new Point(1420, 697));
        greenlandToAustralia.way.add(new Point(1394, 693));
        shipRaces.addAll(Arrays.asList(afircaToChina, asiaToAustralia, greenlandToAustralia, usaToAfrica, usaToAsia, southAmericaToAfrica, southAmericaToAsia, usaToEurope));
        for (ShipRace shipRace : shipRaces) {
            for (Point point : shipRace.way) {
                point.y += 30;

            }
        }
    }
}
