package peaksoft.dto.request;

import peaksoft.enums.Specialization;

public record InstructorRequest(String firstName, String lastName, String phoneNumber, Specialization specialization) {
}
