package net.aisd.student.honea353058.practice;

import org.encog.engine.network.activation.ActivationReLU;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

public class Practice {

    public BasicNetwork network;

    public Practice() {


        network = new BasicNetwork();
        network.addLayer(new BasicLayer(null, true, 1));
        network.addLayer(new BasicLayer(new ActivationReLU(), true, 5));
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, 1));
        network.getStructure().finalizeStructure();
        network.reset();

        // create training data
        MLDataSet trainingSet = new BasicMLDataSet(new double[][]{{1.0}, {0.75}, {0.0}, {0.25}, {0.5}}, new double[][]{{1.0}, {0.75}, {0.0}, {0.25}, {0.5}});

        // train the neural network
        final ResilientPropagation train = new ResilientPropagation(network, trainingSet);

        for (int i = 0; i < 1000; i++)
            train.iteration();

        train.finishTraining();

        System.out.println(network.calculateError(trainingSet));

        new PracticeGUI(this);

    }

    public static void main(String[] args) {

        new Practice();

    }

}
