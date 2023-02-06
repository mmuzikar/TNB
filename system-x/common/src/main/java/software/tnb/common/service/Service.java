package software.tnb.common.service;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;

public interface Service<C extends ServiceConfig> extends BeforeAllCallback, AfterAllCallback {
}
