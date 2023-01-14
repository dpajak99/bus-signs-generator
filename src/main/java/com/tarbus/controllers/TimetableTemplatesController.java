package com.tarbus.controllers;

import com.tarbus.dto.response.company_timetable_templates.CompanyTimetableTemplateDto;
import com.tarbus.dto.response.company_timetable_templates.CompanyTimetableTemplatesResponse;
import com.tarbus.dto.response.company_timetable_templates.CompanyTimetableTemplatesResponseError;
import com.tarbus.dto.response.company_timetable_templates.CompanyTimetableTemplatesResponseImpl;
import com.tarbus.dto.response.update_action_response.UpdateActionResponse;
import com.tarbus.dto.response.update_action_response.UpdateActionResponseError;
import com.tarbus.dto.response.update_action_response.UpdateActionResponseImpl;
import com.tarbus.dto.response.AssignTimetableTemplatesRequest;
import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.services.jpa.TimetableTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/timetable/templates")
public class TimetableTemplatesController {
    final TimetableTemplateService timetableTemplateService;

    @Autowired
    public TimetableTemplatesController(TimetableTemplateService timetableTemplateService) {
        this.timetableTemplateService = timetableTemplateService;
    }

    @GetMapping({"/company/{companyId}"})
    public ResponseEntity<CompanyTimetableTemplatesResponse> getAvailableCompanyTimetableTemplates(@PathVariable Long companyId) {
        try {
            TimetableTemplateModel timetableTemplateModel = timetableTemplateService.getTimetableTemplateByCompanyId(companyId);
            CompanyTimetableTemplatesResponseImpl companyTimetableTemplatesResponse = new CompanyTimetableTemplatesResponseImpl();
            CompanyTimetableTemplateDto companyTimetableTemplateDto = new CompanyTimetableTemplateDto();
            companyTimetableTemplateDto.setId(timetableTemplateModel.getId());
            companyTimetableTemplatesResponse.setCompanyTimetableTemplateDtoList(List.of(companyTimetableTemplateDto));
            return new ResponseEntity<>(companyTimetableTemplatesResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CompanyTimetableTemplatesResponseError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping({"/upload"})
    public ResponseEntity<UpdateActionResponse> uploadTimetableTemplate(@RequestBody MultipartFile templateFile) {
        UpdateActionResponseError updateActionResponseError = new UpdateActionResponseError();
        updateActionResponseError.setMessage("Not implemented yet");
        return new ResponseEntity<>(updateActionResponseError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping({"/assign"})
    public ResponseEntity<UpdateActionResponse> createTimetableAssignment(AssignTimetableTemplatesRequest assignTimetableTemplatesRequest) {
        UpdateActionResponseError updateActionResponseError = new UpdateActionResponseError();
        updateActionResponseError.setMessage("Not implemented yet");
        return new ResponseEntity<>(updateActionResponseError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping({"/assign"})
    public ResponseEntity<UpdateActionResponse> removeTimetableAssignment(AssignTimetableTemplatesRequest assignTimetableTemplatesRequest) {
        UpdateActionResponseError updateActionResponseError = new UpdateActionResponseError();
        updateActionResponseError.setMessage("Not implemented yet");
        return new ResponseEntity<>(updateActionResponseError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
