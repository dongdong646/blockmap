/*
 *       Copyright© (2020) blockmap Co., Ltd.
 *
 *       This file is part of did-core.
 *
 *       did-core is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       did-core is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with did-core.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.blockmap.did.core.service;

import com.blockmap.did.core.protocol.base.Cpt;
import com.blockmap.did.core.protocol.base.CptBaseInfo;
import com.blockmap.did.core.protocol.request.CptMapArgs;
import com.blockmap.did.core.protocol.request.CptStringArgs;
import com.blockmap.did.core.protocol.response.ResponseData;
import com.webank.wedpr.selectivedisclosure.CredentialTemplateEntity;

/**
 * Service inf for operation on CPT (Claim protocol Type).
 *
 * @author lingfenghe
 */
public interface CptService {

    /**
     * Register a new CPT to the blockchain.
     *
     * @param args the args
     * @return The registered CPT info
     */
    ResponseData<CptBaseInfo> registerCpt(CptMapArgs args);

    /**
     * Register a new CPT with a pre-set CPT ID, to the blockchain.
     *
     * @param args the args
     * @param cptId the CPT ID
     * @return The registered CPT info
     */
    ResponseData<CptBaseInfo> registerCpt(CptMapArgs args, Integer cptId);

    /**
     * Register a new CPT to the blockchain.
     *
     * @param args the args
     * @return The registered CPT info
     */
    ResponseData<CptBaseInfo> registerCpt(CptStringArgs args);

    /**
     * Register a new CPT with a pre-set CPT ID, to the blockchain.
     *
     * @param args the args
     * @param cptId the CPT ID
     * @return The registered CPT info
     */
    ResponseData<CptBaseInfo> registerCpt(CptStringArgs args, Integer cptId);

    /**
     * Query the latest CPT version.
     *
     * @param cptId the cpt id
     * @return The registered CPT info
     */
    ResponseData<Cpt> queryCpt(Integer cptId);

    /**
     * Update the data fields of a registered CPT.
     *
     * @param args the args
     * @param cptId the cpt id
     * @return The updated CPT info
     */
    ResponseData<CptBaseInfo> updateCpt(CptMapArgs args, Integer cptId);

    /**
     * Update the data fields of a registered CPT.
     *
     * @param args the args
     * @param cptId the cpt id
     * @return The updated CPT info
     */
    ResponseData<CptBaseInfo> updateCpt(CptStringArgs args, Integer cptId);

    /**
     * Update the data fields of a registered CPT.
     *
     * @param cptId the cpt id
     * @return The updated CPT info
     */
    ResponseData<CredentialTemplateEntity> queryCredentialTemplate(Integer cptId);
}
