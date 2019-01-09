/*
 * Copyright 2019 Patrick Maher<dev@infracog.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.infracog.SoftLi.am;

/**
 *
 * @author pmaher
 */
public class StatusMessage {
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;

    private final int status;
    private final String message;
    private LicenseRight slr;
    
    public StatusMessage(int status, String message) {
        this.status = status;
        this.message = message;
        slr = null;
    }
    
        public StatusMessage(int status, String message, LicenseRight slr) {
        this.status = status;
        this.message = message;
        this.slr = slr;
    }
        public int getStatus() {
        return status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setSoftwareLicenseRight(LicenseRight slr) {
        this.slr = slr;
    }
    
    public LicenseRight getSoftwareLicenseRight() {
        return slr;
    }
    

}
