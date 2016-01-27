/*
 * (C) Copyright 2015 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */

package org.kurento.test.functional.player;

import static org.kurento.test.config.Protocol.FILE;
import static org.kurento.test.config.Protocol.HTTP;
import static org.kurento.test.config.Protocol.S3;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.kurento.test.browser.WebRtcChannel;
import org.kurento.test.config.Protocol;
import org.kurento.test.config.TestScenario;

/**
 * Test of a the seek feature for a PlayerEndpoint. </p> Media Pipeline(s):
 * <ul>
 * <li>PlayerEndpoint -> WebRtcEndpoint</li>
 * </ul>
 * Browser(s):
 * <ul>
 * <li>Chrome</li>
 * <li>Firefox</li>
 * </ul>
 * Test logic:
 * <ol>
 * <li>(KMS) During the playback of a stream from a PlayerEndpoint to a WebRtcEndpoint, the
 * PlayerEndpoint is sought three times and then resumed</li>
 * <li>(Browser) WebRtcPeer in rcv-only receives media</li>
 * </ol>
 * Main assertion(s):
 * <ul>
 * <li>Color or the video should remain when a video is sought</li>
 * <li>After the seek, the color or the video should change</li>
 * </ul>
 * Secondary assertion(s):
 * <ul>
 * <li>Playing event should be received in remote video tag</li>
 * </ul>
 *
 * @author Raul Benitez (rbenitez@gsyc.es)
 * @since 6.1.1
 */
public class PlayerAudioVideoTrackSeekTest extends FunctionalPlayerTest {

  @Parameters(name = "{index}: {0}")
  public static Collection<Object[]> data() {
    return TestScenario.localChromeAndFirefox();
  }

  private void initTest(Protocol protocol, String nameMedia) throws Exception {
    final Map<Integer, Color> expectedPositionAndColor = new LinkedHashMap<Integer, Color>();
    expectedPositionAndColor.put(2000, Color.RED);
    expectedPositionAndColor.put(10000, Color.BLUE);
    expectedPositionAndColor.put(6000, Color.GREEN);
    expectedPositionAndColor.put(2000, Color.RED);
    expectedPositionAndColor.put(10100, Color.BLUE);

    String mediaUrl = getMediaUrl(protocol, nameMedia);
    int pauseTimeSeconds = 3;
    testPlayerSeek(mediaUrl, WebRtcChannel.AUDIO_AND_VIDEO, pauseTimeSeconds,
        expectedPositionAndColor);
  }

  @Test
  public void testPlayerAudioVideoSeekHttpOgv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.ogv";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekHttpMkv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mkv";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekHttpAvi() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.avi";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekHttpWebm() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.webm";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekHttpMov() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mov";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekHttp3gp() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.3gp";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekHttpMp4() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mp4";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekFileOgv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.ogv";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekFileMkv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mkv";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekFileAvi() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.avi";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekFileWebm() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.webm";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekFileMov() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mov";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekFile3gp() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.3gp";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekFileMp4() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mp4";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekS3Ogv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.ogv";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekS3Mkv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mkv";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekS3Avi() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.avi";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekS3Webm() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.webm";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekS3Mov() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mov";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekS33gp() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.3gp";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerAudioVideoSeekS3Mp4() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgb.mp4";
    initTest(S3, mediaUrl);
  }
}