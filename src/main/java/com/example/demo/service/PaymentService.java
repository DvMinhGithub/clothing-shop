package com.example.demo.service;

import com.example.demo.model.dto.*;
import com.example.demo.model.request.CancelPaymentRequest;
import com.example.demo.model.request.ConfirmWebhookRequest;
import com.example.demo.model.request.CreatePaymentRequest;
import com.example.demo.model.request.QRCodeRequest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface PaymentService {
    QRCodeDto generateQRCode(QRCodeRequest qrCodeRequest) throws URISyntaxException, IOException, InterruptedException;

    CreatePaymentDto createPayment(CreatePaymentRequest createPaymentRequest) throws URISyntaxException, IOException,
            InterruptedException, NoSuchAlgorithmException, InvalidKeyException;

    ConfirmWebhookDto confirmWebhook(ConfirmWebhookRequest confirmWebhookRequest) throws URISyntaxException, IOException,
            InterruptedException;

    CancelPaymentDto cancelPayment(CancelPaymentRequest cancelPaymentRequest, String paymentId) throws URISyntaxException,
            IOException, InterruptedException;

    PaymentInfoDto getPaymentInfo(String paymentId) throws URISyntaxException, IOException, InterruptedException;
}
