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

package com.blockmap.did.core.suite.encode;

import com.blockmap.did.core.exception.EncodeSuiteException;
import com.blockmap.did.core.service.BaseService;
import com.blockmap.did.core.suite.api.persistence.Persistence;
import com.blockmap.did.core.suite.entity.CryptType;
import com.blockmap.did.core.suite.entity.EncodeData;
import com.blockmap.did.core.suite.persistence.sql.driver.MysqlDriver;
import com.blockmap.did.core.suite.crypto.CryptServiceFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 密文编解码处理器.
 * 
 * @author admin@xuzhijun.com.cn
 *
 */
public class CipherEncodeProcessor extends BaseService implements EncodeProcessor {
    
    private static final Logger logger = LoggerFactory.getLogger(CipherEncodeProcessor.class);
    
    private Persistence dataDriver;
    
//    protected AmopService amopService = new AmopServiceImpl();
    
    private Persistence getDataDriver() {
        if (dataDriver == null) {
            dataDriver = new MysqlDriver();
        }
        return dataDriver;
    }
    
    /**
     * 密文编码处理：先进行压缩，然后进行AES加密.
     */
    @Override
    public String encode(EncodeData encodeData) throws EncodeSuiteException {
        return null;
//        logger.info("[encode] cipher encode process, encryption with AES.");
//        try {
//            String key = KeyGenerator.getKey();
//            Map<String, Object> keyMap = new HashMap<String, Object>();
//            keyMap.put(ParamKeyConstant.KEY_DATA, key);
//            keyMap.put(ParamKeyConstant.KEY_VERIFIERS, encodeData.getVerifiers());
//            String saveData = DataToolUtils.serialize(keyMap);
//
//            //将数据进行AES加密处理
//            String value =
//                CryptServiceFactory
//                    .getCryptService(CryptType.AES)
//                    .encrypt(encodeData.getData(), key);
//
//            //保存秘钥
//            ResponseData<Integer> response = this.getDataDriver().save(
//                DataDriverConstant.DOMAIN_ENCRYPTKEY, encodeData.getId(), saveData);
//            if (response.getErrorCode().intValue() != ErrorCode.SUCCESS.getCode()) {
//                throw new EncodeSuiteException(
//                    ErrorCode.getTypeByErrorCode(response.getErrorCode().intValue())
//                );
//            }
//            logger.info("[encode] cipher encode process finished.");
//            return value;
//        } catch (EncodeSuiteException e) {
//            logger.error("[encode] encode processor has some error.", e);
//            throw e;
//        } catch (Exception e) {
//            logger.error("[encode] encode processor has unknow error.", e);
//            throw new EncodeSuiteException(e);
//        }
    }
    
    /**
     * 密文解码处理：先进行AES解密， 然后进行解压.
     */
    @Override
    public String decode(EncodeData encodeData) throws EncodeSuiteException {
        logger.info("[decode] cipher decode process, decryption with AES.");
        try {
            String key = this.getEntryptKey(encodeData);
            //将数据进行AES解密
            String value = 
                CryptServiceFactory
                    .getCryptService(CryptType.AES)
                    .decrypt(encodeData.getData(), key);
            //数据进行解压
            logger.info("[decode] cipher decode process finished.");
            return value;
        } catch (EncodeSuiteException e) {
            logger.error("[decode] decode processor has some error.", e);
            throw e;
        } catch (Exception e) {
            logger.error("[decode] decode processor has unknow error.", e);
            throw new EncodeSuiteException(e);
        }  
    }
    
    /**
     * 获取秘钥.
     * 
     * @param encodeData 编解码实体
     * @return return the key
     */
    private String getEntryptKey(EncodeData encodeData) {
        //说明是当前机构，这个时候不适用于AMOP获取key，而是从本地数据库中获取key
//        if (fiscoConfig.getCurrentOrgId().equals(encodeData.getOrgId())) {
//            //保存秘钥
//            ResponseData<String> response =
//                this.getDataDriver().get(DataDriverConstant.DOMAIN_ENCRYPTKEY, encodeData.getId());
//            if (response.getErrorCode().intValue() != ErrorCode.SUCCESS.getCode()) {
//                throw new EncodeSuiteException(
//                    ErrorCode.getTypeByErrorCode(response.getErrorCode().intValue())
//                );
//            }
//            return this.getEncryptKey(encodeData, response.getResult());
//        } else {
//            //获取秘钥，
//            return this.requestEncryptKeyByAmop(encodeData);
//        }
        return null;
    }
    
    /**
     * 本机构取秘钥(需要判断权限控制).
     * 
     * @param encodeData 编解码实体
     * @param value 数据库中存储的秘钥结构数据
     * @return 返回秘钥
     */
    private String getEncryptKey(EncodeData encodeData, String value) {
        return null;
//        if (encodeData.getDidAuthentication() == null) {
//            logger.info("[getEncryptKey] the weid Authentication is null.");
//            throw new EncodeSuiteException(ErrorCode.ENCRYPT_KEY_NO_PERMISSION);
//        }
//        try {
//            Map<String, Object> keyMap = DataToolUtils.deserialize(
//                value,
//                new HashMap<String, Object>().getClass()
//            );
//            String weId = encodeData.getDidAuthentication().getDid();
//            List<String> verifiers = (ArrayList<String>)keyMap.get(ParamKeyConstant.KEY_VERIFIERS);
//            // 如果verifiers为empty,或者传入的weId为空，或者weId不在指定列表中，则无权限获取秘钥数据
//            if (CollectionUtils.isEmpty(verifiers)
//                || StringUtils.isBlank(weId)
//                || !verifiers.contains(weId)) {
//                logger.error("[getEncryptKey] no access to get the data, this weid is {}.", weId);
//                throw new EncodeSuiteException(ErrorCode.ENCRYPT_KEY_NO_PERMISSION);
//            }
//            return (String)keyMap.get(ParamKeyConstant.KEY_DATA);
//        } catch (DataTypeCastException e) {
//            logger.error("[getEncryptKey] deserialize the data error, you should upgrade SDK.", e);
//            throw new EncodeSuiteException(ErrorCode.ENCRYPT_KEY_INVALID);
//        }
    }
    
    /**
     * 通过AMOP获取秘钥.
     * @param encodeData 编解码实体
     * @return 返回秘钥
     */
    private String requestEncryptKeyByAmop(EncodeData encodeData) {
        return null;
//        GetEncryptKeyArgs args = new GetEncryptKeyArgs();
//        args.setKeyId(encodeData.getId());
//        args.setMessageId(DataToolUtils.getUuId32());
//        args.setToOrgId(encodeData.getOrgId());
//        args.setFromOrgId(fiscoConfig.getCurrentOrgId());
//        if (encodeData.getDidAuthentication() != null) {
//            String signValue = DataToolUtils.sign(
//                encodeData.getId(),
//                encodeData.getDidAuthentication().getDidPrivateKey().getPrivateKey()
//            );
//            args.setSignValue(signValue);
//            args.setDid(encodeData.getDidAuthentication().getDid());
//        }
//        ResponseData<GetEncryptKeyResponse> resResponse =
//            amopService.getEncryptKey(encodeData.getOrgId(), args);
//        if (resResponse.getErrorCode().intValue() != ErrorCode.SUCCESS.getCode()) {
//            logger.error(
//                "[requestEncryptKeyByAmop] AMOP response fail, dataId={}, "
//                + "errorCode={}, errorMessage={}",
//                encodeData.getId(),
//                resResponse.getErrorCode(),
//                resResponse.getErrorMessage()
//            );
//            throw new EncodeSuiteException(
//                ErrorCode.getTypeByErrorCode(resResponse.getErrorCode().intValue())
//            );
//        }
//        GetEncryptKeyResponse keyResponse = resResponse.getResult();
//        ErrorCode errorCode =
//                ErrorCode.getTypeByErrorCode(keyResponse.getErrorCode().intValue());
//        if (errorCode.getCode() != ErrorCode.SUCCESS.getCode()) {
//            logger.error(
//                "[requestEncryptKeyByAmop] requestEncryptKey error, dataId={},"
//                + " errorCode={}, errorMessage={}",
//                encodeData.getId(),
//                keyResponse.getErrorCode(),
//                keyResponse.getErrorMessage()
//            );
//            throw new EncodeSuiteException(errorCode);
//        }
//        return keyResponse.getEncryptKey();
    }
}
