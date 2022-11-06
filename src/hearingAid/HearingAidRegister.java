package hearingAid;

import hearingAid.HearingAid;

import java.util.*;

public class HearingAidRegister {

    private Map<String, HearingAid> hearingAidMap;

    public HearingAidRegister() {
        hearingAidMap = new HashMap<>();
    }

    public void fillHearingAidMap() {
        HearingAid hearingAid1 = new HearingAid("1001", "Hørselsapparat", true, "Vegard");
        HearingAid hearingAid2 = new HearingAid("1002", "Hørselsapparat");
        HearingAid hearingAid3 = new HearingAid("1003", "Hørselsapparat");
        HearingAid hearingAid4 = new HearingAid("1004", "Hørselsapparat");

        hearingAidMap.put(hearingAid1.getId(), hearingAid1);
        hearingAidMap.put(hearingAid2.getId(), hearingAid2);
        hearingAidMap.put(hearingAid3.getId(), hearingAid3);
        hearingAidMap.put(hearingAid4.getId(), hearingAid4);

    }

    public Map<String, HearingAid> getHearingAidMap() {
        return hearingAidMap;
    }

    public void registerHearingAid(HearingAid hearingAid) {
        Iterator<HearingAid> hearingAidIterator = getIterator();
        while (hearingAidIterator.hasNext()) {
            HearingAid hearingAidTemp = hearingAidIterator.next();
            if (hearingAidTemp.getId().equalsIgnoreCase(hearingAid.getId())) {
                hearingAid.setId("INVALID");
            } else {
                hearingAidMap.put(hearingAid.getId(), hearingAid);
            }
        }
    }

    public void rentHearingAid(String id, String nameOfBorrower) {
        Iterator<HearingAid> hearingAidIterator = getIterator();
        while(hearingAidIterator.hasNext()) {
            HearingAid hearingAidTemp = hearingAidIterator.next();
            if(hearingAidTemp.getId().equalsIgnoreCase(id) && !hearingAidTemp.isRentalStatus()){
                hearingAidTemp.setRentalStatus(true);
                hearingAidTemp.setNameOfBorrower(nameOfBorrower);
            }
        }
    }

    public void endRentalPeriod(String id) {
        Iterator<HearingAid> hearingAidIterator = getIterator();
        while(hearingAidIterator.hasNext()) {
            HearingAid hearingAidTemp = hearingAidIterator.next();
            if(hearingAidTemp.getId().equalsIgnoreCase(id) && hearingAidTemp.isRentalStatus()){
                hearingAidTemp.setRentalStatus(false);
                hearingAidTemp.setNameOfBorrower("");
            }
        }
    }

    public List<HearingAid> getInformation() {
        Iterator<HearingAid> hearingAidIterator = getIterator();
        List<HearingAid> hearingAidInfoList = new ArrayList<>();
        while(hearingAidIterator.hasNext()) {
            HearingAid hearingAidTemp = hearingAidIterator.next();
            hearingAidInfoList.add(hearingAidTemp);
            }
        return hearingAidInfoList;
        }

        public List<HearingAid> getAvailableHearingAidsByType(String type){
            Iterator<HearingAid> hearingAidIterator = getIterator();
            List<HearingAid> hearingAidInfoList = new ArrayList<>();
            while(hearingAidIterator.hasNext()) {
                HearingAid hearingAidTemp = hearingAidIterator.next();
                if(hearingAidTemp.getType().equalsIgnoreCase(type)) {
                    hearingAidInfoList.add(hearingAidTemp);
                }
            }
            return hearingAidInfoList;
        }

    public Iterator<HearingAid> getIterator() {
        return hearingAidMap.values().iterator();
    }
}
