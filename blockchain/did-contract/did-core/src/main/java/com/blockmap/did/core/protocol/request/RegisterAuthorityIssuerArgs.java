/*
 *       Copyright© (2018) blockmap Co., Ltd.
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

package com.blockmap.did.core.protocol.request;

import com.blockmap.did.core.protocol.base.AuthorityIssuer;
import com.blockmap.did.core.protocol.base.DidPrivateKey;
import lombok.Data;

/**
 * The Arguments for SDK RegisterAuthorityIssuer.
 *
 * @author chaoxinhu 2018.10
 */
@Data
public class RegisterAuthorityIssuerArgs {

    /**
     * Required: The authority issuer information.
     */
    private AuthorityIssuer authorityIssuer;

    /**
     * Required: The Didentity DID private key for sending transaction.
     */
    private DidPrivateKey didPrivateKey;
}
