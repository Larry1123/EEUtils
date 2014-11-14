/*
 * Copyright 2014 ElecEntertainment
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.larry1123.elec.util.io;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.ThresholdingOutputStream;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Larry1123
 * @since 11/12/2014 - 4:01 PM
 */
public class ProxyOutputSteam extends ThresholdingOutputStream {

    protected ByteArrayOutputStream memoryOutputStream;
    protected OutputStream out;

    public ProxyOutputSteam(OutputStream outputStream) {
        super(512);
        memoryOutputStream = new ByteArrayOutputStream(512);
        out = outputStream;
    }

    public void setOutputStream(OutputStream outputStream) throws IOException {
        if (out instanceof ByteArrayOutputStream) {
            // restore that lost buffer
            ((ByteArrayOutputStream) out).writeTo(outputStream);
        }
        else {
            // Lets not cause a new ByteArrayOutputStream to be made just before it is not needed
            drainMemoryOutputSteam();
            out.close();
        }
        out = outputStream;
    }

    @Override
    public void close() throws IOException {
        drainMemoryOutputSteam();
        out.close();
        out = new ByteArrayOutputStream(512);
    }

    @Override
    protected OutputStream getStream() throws IOException {
        return memoryOutputStream;
    }

    @Override
    protected void thresholdReached() throws IOException {
        drainMemoryOutputSteam();
    }

    protected void drainMemoryOutputSteam() throws IOException {
        memoryOutputStream.writeTo(out);
        out.flush();
        resetByteCount();
    }

}
