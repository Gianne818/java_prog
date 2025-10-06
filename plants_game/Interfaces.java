interface SunProducer { int produce_sun(); }
interface PlantUpgrade { int concurrentSunCost(); }
interface Upgradable { PlantUpgrade upgrade(); }
interface Attacker { int attack(); int rangeType(); }
interface InstantKiller{ int killType(); }
