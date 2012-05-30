/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package br.com.syspartenon.partenon.util;

import java.io.IOException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以生成唯一的ID，16个字节，128位。同时提供了一些工具方法。
 * 
 * @author huangshang (yuexuqiang at gmail.com)
 *
 */
public class UniqId {

    private static char[] digits = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static UniqId me = new UniqId();
    private String hostAddr;
    private Random random = new SecureRandom();
    private MessageDigest mHasher;
    private UniqTimer timer = new UniqTimer();
    private ReentrantLock opLock = new ReentrantLock();

    private UniqId() {
        try {
            InetAddress addr = InetAddress.getLocalHost();

            hostAddr = addr.getHostAddress();
        } catch (IOException e) {
            hostAddr = String.valueOf(System.currentTimeMillis());
        }

        if (null == hostAddr || hostAddr.trim().length() == 0
                || "127.0.0.1".equals(hostAddr)) {
            hostAddr = String.valueOf(System.currentTimeMillis());
        }


        try {
            mHasher = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nex) {
            mHasher = null;
        }
    }

    /**
     * 获取UniqID实例
     * @return UniqId
     */
    public static UniqId getInstance() {
        return me;
    }

    /**
     * 获得不会重复的毫秒数
     * @return 不会重复的时间
     */
    public long getUniqTime() {
        return timer.getCurrentTime();
    }

    /**
     * 获得UniqId
     * @return uniqTime-randomNum-hostAddr-threadId
     */
    public String getUniqID() {
        StringBuffer sb = new StringBuffer();
        long t = timer.getCurrentTime();

        sb.append(t);

        sb.append("-");

        sb.append(random.nextInt(8999) + 1000);

        sb.append("-");
        sb.append(hostAddr);

        sb.append("-");
        sb.append(Thread.currentThread().hashCode());


        return sb.toString();
    }

    /**
     * 获取MD5之后的uniqId string
     * @return uniqId md5 string
     */
    public String getUniqIDHashString() {
        return hashString(getUniqID());
    }

    /**
     * 获取MD5之后的uniqId
     * @return uniqId md5 byte[16]
     */
    public byte[] getUniqIDHash() {
        return hash(getUniqID());
    }

    /**
     * 对字符串进行md5
     * @param str
     * @return md5 byte[16]
     */
    public byte[] hash(String str) {
        opLock.lock();
        try {
            byte[] bt = mHasher.digest(str.getBytes());
            if (null == bt || bt.length != 16) {
                throw new IllegalArgumentException("md5 need");
            }
            return bt;
        } finally {
            opLock.unlock();
        }
    }

    /**
     * 对字符串进行md5 string
     * @param str
     * @return md5 string
     */
    public String hashString(String str) {
        byte[] bt = hash(str);
        return bytes2string(bt);
    }

    /**
     * 将一个字节数组转化为可见的字符串
     * @param bt
     * @return 每个字节两位，如f1d2
     */
    public String bytes2string(byte[] bt) {
        int l = bt.length;

        char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = digits[(0xF0 & bt[i]) >>> 4];
            out[j++] = digits[0x0F & bt[i]];
        }


        return new String(out);
    }

    /**
     * 实现不重复的时间
     * @author dogun
     */
    private class UniqTimer {

        private AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());

        public long getCurrentTime() {
            return this.lastTime.incrementAndGet();
        }
    }
}
