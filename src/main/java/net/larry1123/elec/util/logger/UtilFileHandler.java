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
package net.larry1123.elec.util.logger;

import net.larry1123.elec.util.factorys.FactoryManager;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.ErrorManager;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * @author Larry1123
 * @since 10/19/2014 - 4:37 AM
 */
public class UtilFileHandler extends StreamHandler {

    protected ByteArrayOutputStream memoryOutputStream = new ByteArrayOutputStream(512);

    public UtilFileHandler(OutputStream out) throws IOException {
        setFormatter(new UtilsLogFormat());
        setOutputStream(out);
    }

    @Override
    public synchronized void publish(LogRecord record) {
        super.publish(record);
        // Lets make sure that we write to the OutputStream
        flush();
    }

    @Override
    public synchronized void setOutputStream(OutputStream out) throws SecurityException {
        if (out == null) {
            // Can't let this be null
            throw new NullPointerException();
        }
        try {
            // Need to write what we have in the buffer to the new OutputStream
            memoryOutputStream.writeTo(out);
            memoryOutputStream.reset();
        }
        catch (IOException e) {
            reportError("Unable to move temp buffer!", e, ErrorManager.WRITE_FAILURE);
        }
        super.setOutputStream(out);
    }

    protected LoggerSettings getConfig() {
        return FactoryManager.getFactoryManager().getEELoggerFactory().getLoggerSettings();
    }

    @Override
    public synchronized void close() {
        // Close up shop on the old OutputStream
        super.close();
        // Give the StreamHandler the buffer OutputStream so we don't lose anything
        setOutputStream(memoryOutputStream);
    }

}
