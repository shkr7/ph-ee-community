package org.mifos.pheeBillPay.api.definition;


import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.mifos.pheeBillPay.data.BillInquiryResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Tag(name = "GOV")
public interface BillInquiryApi   {

    @Operation(summary = "Bill Inquiry API from Payer FSP to PBB")
    @GetMapping("/bills/{billId}")
    ResponseEntity<BillInquiryResponseDTO> billInquiry(@RequestHeader(value="Platform-TenantId") String tenantId,
                                                       @RequestHeader(value="X-CorrelationID") String correlationId,
                                                       @RequestHeader(value="X-CallbackURL") String callbackURL,
                                                       @RequestHeader(value = "X-PayerFSP-Id")
                                                               String payerFspId,
                                                       @PathVariable(value = "billId") String billId,
                                                       @RequestParam(value = "fields",defaultValue = "inquiry") String field)
            throws ExecutionException, InterruptedException;
}