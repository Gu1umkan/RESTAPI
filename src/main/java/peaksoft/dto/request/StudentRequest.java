package peaksoft.dto.request;

import peaksoft.enums.StudyFormat;

public record StudentRequest(String fullName, String lastName, String phoneNumber, String email, StudyFormat studyFormat) {
}
