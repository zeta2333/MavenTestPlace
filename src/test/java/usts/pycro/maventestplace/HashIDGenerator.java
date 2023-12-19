package usts.pycro.maventestplace;

/**
 * @author Pycro
 * @version 1.0
 * 2023-11-12 10:48
 */

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.net.InetAddresses;
import com.google.common.primitives.Longs;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.junit.jupiter.api.Test;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author zhanglei
 * @version 2022/10/9
 */
public class HashIDGenerator {

    private static final InetAddressValidator INET_ADDRESS_VALIDATOR =
            InetAddressValidator.getInstance();

    /**
     * @param protocol 协议 (HTTP HTTPS)
     * @param hostname 域名, 格式: {domain|ipv4|[ipv6]}[:port][/path]
     * @return 应用ID
     */
    public static String generateAppId(String protocol, String hostname) {
        checkArgument(protocol != null && hostname != null);
        protocol = protocol.toUpperCase(Locale.US);
        if (hostname.endsWith("/")) {
            hostname = hostname.substring(0, hostname.length() - 1);
        }
        // hostname is ipv6 or contains path
        if (hostname.startsWith("[") || hostname.contains("/")) {
            return Hashing.md5()
                    .hashString(protocol + "://" + hostname, StandardCharsets.UTF_8)
                    .toString();
        }

        // hostname is ipv4 or 域名
        String[] hostport = hostname.split(":");
        String host = hostport[0];
        Integer port = 0;
        if (hostport.length > 1) {
            try {
                port = Integer.parseInt(hostport[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "hostname contains invalid port: " + hostport[1]);
            }
        }
        // hostname is ipv4
        if (InetAddresses.isInetAddress(host)) {
            return generateAppId(protocol, host, port);
        }
        // hostname is 域名
        return Hashing.md5()
                .hashString(protocol + "://" + hostname, StandardCharsets.UTF_8)
                .toString();
    }

    private static long protocolToLong(String protocol) {
        switch (protocol) {
            case "HTTP":
                return 0L;
            case "HTTPS":
                return 1L << 48;
            default:
                throw new IllegalArgumentException("protocol is invalid: " + protocol);
        }
    }

    /**
     * @param protocol 协议 HTTP 或 HTTPS, 大写
     * @param ip       ipv4
     * @param port     端口
     * @return 应用ID
     */
    public static String generateAppId(String protocol, String ip, Integer port) {
        long result = (protocol.equals("HTTP") ? 0L : 1L) << 48;
        String[] split = ip.split("\\.");
        for (int j = 0; j < split.length; j++) {
            String s = split[j];
            long i = Integer.parseInt(s);
            result += i << (8 * (5 - j));
        }
        result += port;

        return encode(Longs.toByteArray(result));
    }

    @Test
    public void testGenerateAppId() {
        String appId1 = generateAppId("HTTP", "117.161.2.2", 8010);
        String appId2 = generateAppId("HTTP", "10.209.88.200", 21000);
        String appId3 = generateAppId("HTTP", "10.209.88.200", 18082);
        String appId4 = generateAppId("HTTP", "10.209.88.200", 8090);
        System.out.println("创建物流单: " + appId1);
        System.out.println("5G专网运营平台接口: " + appId2);
        System.out.println("换机初始化接口、1319提交服务: " + appId3);
        System.out.println("宽带账号已订购资费信息查询接口: " + appId4);
    }

    /**
     * @param protocol 协议
     * @param ip       ipv4 / [ipv6]
     * @param port     端口
     * @return
     */
    public static String generateExtId(String protocol, String ip, Integer port) {
        checkArgument(protocol != null && ip != null && port != null);
        protocol = protocol.toUpperCase(Locale.US);
        return Hashing.md5()
                .hashString(protocol + "://" + ip + ":" + port, StandardCharsets.UTF_8)
                .toString();
    }

    /**
     * 和appid可以唯一确认一个接口
     *
     * @param uri
     * @param method HTTP 方法, 方法 (GET HEAD POST PUT DELETE CONNECT OPTIONS TRACE PATCH)
     * @return
     */
    public static String generateApiId(String uri, String method) {
        checkArgument(uri != null && method != null);
        if (uri.isEmpty()) {
            uri = "/";
        } else if (!uri.equals("/") && uri.endsWith("/")) {
            uri = uri.substring(0, uri.length() - 1);
        }
        HashCode hashCode = Hashing.md5().hashString(uri, StandardCharsets.UTF_8);
        byte[] bytes = hashCode.asBytes();
        bytes[bytes.length - 1] += httpMethod(method.toUpperCase(Locale.US));
        return encode(bytes);
    }

    private static byte httpMethod(String method) {
        switch (method) {
            case "GET":
                return 0;
            case "HEAD":
                return 1;
            case "POST":
                return 2;
            case "PUT":
                return 3;
            case "DELETE":
                return 4;
            case "CONNECT":
                return 5;
            case "OPTIONS":
                return 6;
            case "TRACE":
                return 7;
            case "PATCH":
                return 8;
            case "ACL":
                return 9;
            case "BASELINE-CONTROL":
                return 10;
            case "BIND":
                return 11;
            case "CHECKIN":
                return 12;
            case "CHECKOUT":
                return 13;
            case "COPY":
                return 14;
            case "LABEL":
                return 15;
            case "LINK":
                return 16;
            case "LOCK":
                return 17;
            case "MERGE":
                return 18;
            case "MKACTIVITY":
                return 19;
            case "MKCALENDAR":
                return 20;
            case "MKCOL":
                return 21;
            case "MKREDIRECTREF":
                return 22;
            case "MKWORKSPACE":
                return 23;
            case "MOVE":
                return 24;
            case "ORDERPATCH":
                return 25;
            case "PRI":
                return 26;
            case "PROPFIND":
                return 27;
            case "PROPPATCH":
                return 28;
            case "REBIND":
                return 29;
            case "REPORT":
                return 30;
            case "SEARCH":
                return 31;
            case "UNBIND":
                return 32;
            case "UNCHECKOUT":
                return 33;
            case "UNLINK":
                return 34;
            case "UNLOCK":
                return 35;
            case "UPDATE":
                return 36;
            case "UPDATEREDIRECTREF":
                return 37;
            case "VERSION-CONTROL":
                return 38;
            case "*":
                return 39;
        }
        throw new IllegalArgumentException("unsupported http method: " + method);
    }

    /**
     * @param dbUri    大写协议://ipv4:port 或 大写协议://[ipv6]:port
     * @param instance
     * @param schema   单个schema 区分大小写
     * @return
     */
    public static String generateDbId(String dbUri, String instance, String schema) {
        checkArgument(
                dbUri != null
                        && instance != null
                        && schema != null);
        return Hashing.md5()
                .hashString(
                        dbUri + "/" + instance + "/" + schema,
                        StandardCharsets.UTF_8)
                .toString();
    }

    public static String generateDbId(String dbUri) {
        checkArgument(dbUri != null);
        return Hashing.md5().hashString(dbUri, StandardCharsets.UTF_8).toString();
    }

    /**
     * @param protocol 大写协议
     * @param ip       ip ipv6 加方括号
     * @param port     端口
     * @param url      连接串
     * @return
     */
    public static String generateDbUri(String protocol, String ip, int port, String url) {
        if (url != null && url.length() > 0) {
            int q = url.indexOf("?");
            if (q > 0) {
                url = url.substring(0, q);
            }
            return url;
        } else {
            checkArgument(
                    protocol != null
                            && ip != null
                            && port > 0);
            return protocol.toUpperCase() + "://" + ip + ":" + port;
        }
    }

    /**
     * 配合meta_asset_id唯一确认一个表信息
     *
     * @param schema 单个 schema
     * @param table
     * @return
     */
    public static String generateTableId(String schema, String table) {
        checkArgument(schema != null && table != null);
        return Hashing.md5()
                .hashString(schema + "/" + table, StandardCharsets.UTF_8)
                .toString();
    }

    private static final char[] LOOKUP_TABLE_LOWER =
            new char[]{
                    0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x61, 0x62, 0x63, 0x64,
                    0x65, 0x66
            };
    private static final char[] LOOKUP_TABLE_UPPER =
            new char[]{
                    0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x41, 0x42, 0x43, 0x44,
                    0x45, 0x46
            };

    private static String encode(byte[] byteArray, boolean upperCase, ByteOrder byteOrder) {

        // our output size will be exactly 2x byte-array length
        final char[] buffer = new char[byteArray.length * 2];

        // choose lower or uppercase lookup table
        final char[] lookup = upperCase ? LOOKUP_TABLE_UPPER : LOOKUP_TABLE_LOWER;

        int index;
        for (int i = 0; i < byteArray.length; i++) {
            // for little endian we count from last to first
            index = (byteOrder == ByteOrder.BIG_ENDIAN) ? i : byteArray.length - i - 1;

            // extract the upper 4 bit and look up char (0-A)
            buffer[i << 1] = lookup[(byteArray[index] >> 4) & 0xF];
            // extract the lower 4 bit and look up char (0-A)
            buffer[(i << 1) + 1] = lookup[(byteArray[index] & 0xF)];
        }
        return new String(buffer);
    }

    private static String encode(byte[] byteArray) {
        return encode(byteArray, false, ByteOrder.BIG_ENDIAN);
    }

    // public static boolean isValidInet4Address(@Nullable String inet4Address) {
    //     return INET_ADDRESS_VALIDATOR.isValidInet4Address(inet4Address);
    // }
    //
    // public static boolean isValidInet6Address(@Nullable String inet6Address) {
    //     if (inet6Address == null) {
    //         return false;
    //     }
    //     return INET_ADDRESS_VALIDATOR.isValidInet6Address(inet6Address);
    // }
}

