/*************************************************************************************
 * Copyright (C) 2014-2020 GENERAL BYTES s.r.o. All rights reserved.
 *
 * This software may be distributed and modified under the terms of the GNU
 * General Public License version 2 (GPL2) as published by the Free Software
 * Foundation and appearing in the file GPL2.TXT included in the packaging of
 * this file. Please note that GPL2 Section 2[b] requires that all works based
 * on this software must also be made publicly available under the terms of
 * the GPL2 ("Copyleft").
 *
 * Contact information
 * -------------------
 *
 * GENERAL BYTES s.r.o.
 * Web      :  http://www.generalbytes.com
 *
 ************************************************************************************/
package com.generalbytes.batm.server.extensions;

import com.generalbytes.batm.server.extensions.aml.verification.ApplicantCheckResult;
import com.generalbytes.batm.server.extensions.aml.verification.IdentityApplicant;

public interface IIdentityListener {
    /**
     * Called by the server when an identity verification result is received from an identity verification provider.
     *
     * @param rawPayload raw data received from the identity verification provider (e.g. in a webhook).
     *                   Might be used to access additional data not recognized by the identity verification extension.
     * @param result     data parsed by the identity verification extension.
     *                   Contains identity applicant ID that could be used to obtain the Identity,
     *                   see {@link IExtensionContext#findIdentityVerificationApplicant(String)}
     *                   and {@link IdentityApplicant#getIdentity()}
     */
    default void onIdentityVerificationResult(String rawPayload, ApplicantCheckResult result) {
    }

    /**
     * Called when a new identity is created by the master or admin service.
     *
     * @param publicIdentityId Public ID of the newly created identity.
     */
    default void onIdentityCreated(String publicIdentityId) {
    }

    /**
     * Called whenever the admin or master service changes the state of an identity.
     *
     * @param publicIdentityId Public ID of the identity whose state has changed.
     * @param stateFrom        The previous state of the identity before the change.
     * @param stateTo          The new state of the identity after the change.
     */
    default void onIdentityStateChanged(String publicIdentityId, int stateFrom, int stateTo) {
    }
}
