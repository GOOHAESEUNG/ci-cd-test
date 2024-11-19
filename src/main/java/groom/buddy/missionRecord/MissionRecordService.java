package groom.buddy.missionRecord;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionRecordService {

    private final MissionRecordRepository missionRecordRepository;

    public MissionRecord createMissionRecord(String content,String feedback){
        MissionRecord missionRecord = new MissionRecord();
        missionRecord.setContent(content);
        missionRecord.setFeedback(feedback);

        return missionRecordRepository.save(missionRecord);
    }
}
