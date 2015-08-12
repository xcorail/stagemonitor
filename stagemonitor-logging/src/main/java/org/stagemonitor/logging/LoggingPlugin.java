package org.stagemonitor.logging;

import java.util.Collections;
import java.util.List;

import com.codahale.metrics.MetricRegistry;
import org.stagemonitor.core.CorePlugin;
import org.stagemonitor.core.StagemonitorPlugin;
import org.stagemonitor.core.configuration.Configuration;
import org.stagemonitor.core.elasticsearch.ElasticsearchClient;

public class LoggingPlugin extends StagemonitorPlugin {

	@Override
	public void initializePlugin(MetricRegistry metricRegistry, Configuration configuration) {
		ElasticsearchClient elasticsearchClient = configuration.getConfig(CorePlugin.class).getElasticsearchClient();
		elasticsearchClient.sendGrafanaDashboardAsync("Logging.json");
	}

	@Override
	public List<String> getPathsOfWidgetMetricTabPlugins() {
		return Collections.singletonList("/stagemonitor/static/tabs/metrics/logging-metrics");
	}

}
