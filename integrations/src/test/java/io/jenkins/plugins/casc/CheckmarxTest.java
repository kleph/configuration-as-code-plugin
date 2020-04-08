package io.jenkins.plugins.casc;

import io.jenkins.plugins.casc.misc.ConfiguredWithReadme;
import io.jenkins.plugins.casc.misc.JenkinsConfiguredWithReadmeRule;
import jenkins.model.Jenkins;

import com.checkmarx.jenkins.CxScanBuilder;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class CheckmarxTest {

    @Rule
    public JenkinsConfiguredWithReadmeRule j = new JenkinsConfiguredWithReadmeRule();

    @Test
    @ConfiguredWithReadme(value = "checkmarx/README.md")
    public void configure_checkmarx() throws Exception {
        final Jenkins jenkins = Jenkins.get();
        final CxScanBuilder.DescriptorImpl cxScanConfig = (CxScanBuilder.DescriptorImpl) jenkins.getDescriptor(CxScanBuilder.class);
        assertThat(cxScanConfig, is(notNullValue()));
        assertThat(cxScanConfig.isOldCredentials(), is(false));
        assertThat(cxScanConfig.getServerUrl(), is(equalTo("https://checkmarx.url.tld")));
    }
}
